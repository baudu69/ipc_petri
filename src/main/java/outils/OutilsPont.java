package outils;

import renvoie.RenvoieAjoutFils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutilsPont {

    static Map<List<Integer>, List<List<Integer>>> lesMGG = new HashMap<>();

    /**
     * PONT
     *
     * @param arbre_dict     un dictionnaire qui à chaque identifiant associe son parent dans l'arbre
     * @param arbre_tab      un tableau qui à chaque identifiant associe un marquage
     * @param iden           identifiant du parent
     * @param franchissables id des transitions franchissables depuis l'endroit où l'on se trouve
     * @param P              Nombre de places P
     * @param T              Nombre de transitions T
     * @param pre            Un tableau pre[p][t] qui indique combien de jetons doivent être pris dans p quand on emprunte t
     *                       * @param post Un tableau post[p][t] qui indique combien de jetons doivent être ajoutés dans p quand on emprunte t
     *                       * @param m Un marquage est représenté par un tableau m (m[p]=nombre de jetons dans p)
     * @return true si borné, false sinon
     */
    public static int estBorneWorkerLEPONTDAVIGNON(List<Integer> arbre_dict, List<List<Integer>> arbre_tab, int iden, List<Integer> franchissables, int P, int T, List<List<Integer>> pre, List<List<Integer>> post, List<Integer> m) {
        List<List<Integer>> listeAncetre = Outils.ancetres(arbre_dict, arbre_tab, iden);
        if (isAvignonFinished(m)) {
            lesMGG.put(m, List.copyOf(listeAncetre));
        }

        //Condition 2 : Si `f` a un ancêtre étiqueté par `N` tel que `∀q, M(q) <= N(q)` et `∃p, M(p) < N(p)`,
        // alors on s'arrête (le réseau est non borné)
        for (List<Integer> ancetre : listeAncetre) {
            if (Outils.temoin(ancetre, m)) {
                return 0;
            }
        }
        //Condition 1 : Si `f` a un ancêtre étiqueté par `M`, on passe à la feuille suivante.
        listeAncetre.remove(listeAncetre.size() - 1); //On s'auto-enlève de la liste des ancetres
        if (listeAncetre.contains(m) && iden != 0) {
            return -1;
        }

        //Sinon, pour chaque transition `t` admissible par `M`, on calcule `M'` tel que `M --t-> M'`,
        // et on ajoute un fils à `f`, étiqueté par `M'`.
        int idenPere = iden;
        for (Integer t : franchissables) {

            List<Integer> mPrime = new ArrayList<>(m);

            for (int i = 0; i < P; i++) {
                List<Integer> preDeP = pre.get(i);
                mPrime.set(i, mPrime.get(i) - preDeP.get(t));

                List<Integer> postDeP = post.get(i);
                mPrime.set(i, mPrime.get(i) + postDeP.get(t));
            }
            RenvoieAjoutFils arbre = Outils.ajoutFils(arbre_dict, arbre_tab, idenPere, mPrime);
            iden = arbre.arbre_dict().size() - 1;

            int result = estBorneWorkerLEPONTDAVIGNON(arbre.arbre_dict(), arbre.arbre_tab(), iden, Outils.franchissable(P, T, pre, post, mPrime), P, T, pre, post, mPrime);
            if (result == 0)
                return 0;
        }

        return 1;
    }

    /**
     * PONT
     * Vérifie qu'un réseau est borné
     *
     * @param P    Nombre de places P
     * @param T    Nombre de transitions T
     * @param pre  Un tableau pre[p][t] qui indique combien de jetons doivent être pris dans p quand on emprunte t
     * @param post Un tableau post[p][t] qui indique combien de jetons doivent être ajoutés dans p quand on emprunte t
     * @param m    Un marquage est représenté par un tableau m (m[p]=nombre de jetons dans p)
     * @return true si borné, false sinon
     */
    public static boolean estBorneAVIGNON(int P, int T, List<List<Integer>> pre, List<List<Integer>> post, List<Integer> m) {
        RenvoieAjoutFils arbre = Outils.ajoutFils(new ArrayList<>(), new ArrayList<>(), 0, m);
        List<Integer> franchissables = Outils.franchissable(P, T, pre, post, m);
        boolean etat = estBorneWorkerLEPONTDAVIGNON(arbre.arbre_dict(), arbre.arbre_tab(), 0, franchissables, P, T, pre, post, m) == 1;
        finirPartie();
        return etat;
    }

    /**
     * PONT
     * Regarde la solution la plus petite et affiche les résultats
     */
    public static void finirPartie() {
        Map.Entry<List<Integer>, List<List<Integer>>> entry = lesMGG.entrySet().iterator().next();
        int mini = entry.getKey().get(entry.getKey().size() - 1);
        List<Integer> finale = new ArrayList<>();
        List<List<Integer>> ancetreFinal = new ArrayList<>();
        for (Map.Entry<List<Integer>, List<List<Integer>>> entry1 : lesMGG.entrySet()) {
            if (entry1.getKey().get(entry1.getKey().size() - 1) < mini) {
                mini = entry1.getKey().get(entry1.getKey().size() - 1);
            }
        }
        for (var entry1 : lesMGG.entrySet()) {
            if (entry1.getKey().get(entry1.getKey().size() - 1) == mini) {
                ancetreFinal = entry1.getValue();
            }
        }
        System.out.printf("La solution la plus courte va prendre %s minutes%n", mini);
        afficherAncetreGagnant(ancetreFinal);
    }

    /**
     * PONT
     * Affiche la solution choisie en lui passant la liste dans ancetres
     *
     * @param ancetres liste des ancetres
     */
    public static void afficherAncetreGagnant(List<List<Integer>> ancetres) {
        for (int i = 1; i < ancetres.size(); i++) {
            System.out.println("--Tour n°" + i + "--");
            for (int j = 0; j < 4; j++) {
                String joueur = "";
                switch (j) {
                    case 0 -> joueur = "A";
                    case 1 -> joueur = "B";
                    case 2 -> joueur = "C";
                    case 3 -> joueur = "D";
                }
                if (ancetres.get(i).get(j) < ancetres.get(i - 1).get(j)) {
                    System.out.printf("%s a traversé le pont dans le sens aller%n", joueur);
                } else if (ancetres.get(i).get(j) > ancetres.get(i - 1).get(j)) {
                    System.out.printf("%s a traversé le pont dans le sens retour%n", joueur);
                } else {
                    System.out.printf("%s n'a pas bougé durant ce tour%n", joueur);
                }
            }
            System.out.println();
        }
    }

    /**
     * PONT
     * <p>
     * Vérifie que la partie est terminée
     *
     * @param m Position des jetons
     * @return true si la partie est terminée
     */
    public static boolean isAvignonFinished(List<Integer> m) {
        for (int i = 0; i < 5; i++) {
            if (m.get(i) != 0) {
                return false;
            }
        }
        return true;
    }
}
