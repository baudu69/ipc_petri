package outils;

import renvoie.RenvoieAjoutFils;
import java.util.ArrayList;
import java.util.List;

public class Outils {

    /**
     *
     * @param P Nombre de places P
     * @param T Nombre de transitions T
     * @param pre Un tableau pre[p][t] qui indique combien de jetons doivent être pris dans p quand on emprunte t
     * @param post Un tableau post[p][t] qui indique combien de jetons doivent être ajoutés dans p quand on emprunte t
     * @param m Un marquage est représenté par un tableau m (m[p]=nombre de jetons dans p)
     */
    public static List<Integer> franchissable(int P, int T, List<List<Integer>> pre, List<List<Integer>> post, List<Integer> m) {
        List<Integer> transitionsFranchissables = new ArrayList<>();
        for (int i = 0; i < T; i++) { // T
            boolean tPossible = true;
            for (int j = 0; j < P; j++) { // P
                if (pre.get(j).get(i) > m.get(j)) {
                    tPossible = false;
                    break;
                }
            }
            if (tPossible) {
                transitionsFranchissables.add(i);
            }
        }
        return transitionsFranchissables;
    }


    public static RenvoieAjoutFils ajoutFils(List<Integer> arbre_dict, List<List<Integer>> arbre_tab, int iden, List<Integer> m) {
        arbre_dict.add(iden);
        arbre_tab.add(m);
        return new RenvoieAjoutFils(arbre_dict, arbre_tab);
    }

    public static List<List<Integer>> ancetres(List<Integer> arbre_dict, List<List<Integer>> arbre_tab, int iden) {
        if (iden == 0) {
            List<List<Integer>> lists = new ArrayList<>();
            lists.add(arbre_tab.get(iden));
            return lists;
        } else {
            int iden_parent = arbre_dict.get(iden);
            List<List<Integer>> a = ancetres(arbre_dict, arbre_tab, iden_parent);
            a.add(arbre_tab.get(iden));
            return a;
        }
    }

    public static boolean temoin(List<Integer> m1, List<Integer> m2) {
        boolean test = false;
        for (int p = 0; p < m1.size(); p++) {
            if (m1.get(p) > m2.get(p)) {
                return false;
            } else if (m1.get(p) < m2.get(p)) {
                test = true;
            }
        }
        return test;
    }


    public static boolean estBorneWorker(List<Integer> arbre_dict, List<List<Integer>> arbre_tab, int iden, List<Integer> franchissables, int P, int T, List<List<Integer>> pre, List<List<Integer>> post, List<Integer> m) {
        List<List<Integer>> listeAncetre = ancetres(arbre_dict, arbre_tab, iden);

        //Condition 1 : Si `f` a un ancêtre étiqueté par `M`, on passe à la feuille suivante.
        if(listeAncetre.contains(m)) {
            return true;
        }

        //Condition 2 : Si `f` a un ancêtre étiqueté par `N` tel que `∀q, M(q) <= N(q)` et `∃p, M(p) < N(p)`,
        // alors on s'arrête (le réseau est non borné)
        for (List<Integer> ancetre : listeAncetre) {
            if(!temoin(ancetre, m)) {
                return false;
            }
        }

        //Sinon, pour chaque transition `t` admissible par `M`, on calcule `M'` tel que `M --t-> M'`,
        // et on ajoute un fils à `f`, étiqueté par `M'`.
        for (Integer t : franchissables) {
            List<Integer> mPrime = new ArrayList<>(m);
            for (int i = 0; i <= P; i++) {
                List<Integer> preDeP = pre.get(i);
                mPrime.set(i, mPrime.get(i) - preDeP.get(t));

                List<Integer> postDeP = post.get(i);
                mPrime.set(i, mPrime.get(i) + postDeP.get(t));
            }

            RenvoieAjoutFils arbre = ajoutFils(arbre_dict, arbre_tab, iden, mPrime);

            boolean result = estBorneWorker(arbre.arbre_dict(), arbre.arbre_tab(), iden, franchissable(P, T, pre, post, mPrime), P, T, pre, post, mPrime);
            if(!result)
                return false;
        }

        return true;

    }

    public static boolean estBorne(int P, int T, List<List<Integer>> pre, List<List<Integer>> post, List<Integer> m) {
        RenvoieAjoutFils arbre = ajoutFils(new ArrayList<>(), new ArrayList<>(), 0, m);
        List<Integer> franchissables = franchissable(P, T, pre, post, m);

        return estBorneWorker(arbre.arbre_dict(), arbre.arbre_tab(), 0, franchissables, P, T, pre, post, m);
    }
}
