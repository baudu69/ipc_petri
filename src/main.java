import outils.Outils;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        int P = 2;
        int T = 3;
        List<Integer> e2 = new java.util.ArrayList<>();
        e2.add(0);
        e2.add(1);
        e2.add(1);
        List<Integer> e1 = new java.util.ArrayList<>();
        e1.add(1);
        e1.add(0);
        e1.add(0);
        List<List<Integer>> pre = new ArrayList<>();
        pre.add(e1);
        pre.add(e2);
        List<List<Integer>> post = new ArrayList<>();
        List<Integer> e = new ArrayList<>();
        e.add(0);
        e.add(2);
        e.add(0);
        post.add(e);
        List<Integer> e3 = new ArrayList<>();
        e3.add(2);
        e3.add(0);
        e3.add(0);
        post.add(e3);
        List<Integer> M = new ArrayList<>();
        M.add(1);
        M.add(0);
        System.out.println("Liste bornee : " + Outils.estBorne(P, T, pre, post, M));
    }
}
