import outils.Outils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {
        int P = 2;
        int T = 3;
        List<Integer> pre1 = Stream.of(1, 0, 0).collect(Collectors.toCollection(ArrayList::new));
        List<Integer> pre2 = Stream.of(0, 1, 1).collect(Collectors.toCollection(ArrayList::new));
        List<List<Integer>> pre = new ArrayList<>();
        pre.add(pre1);
        pre.add(pre2);
        List<List<Integer>> post = new ArrayList<>();
        List<Integer> post1 = Stream.of(0, 1, 0).collect(Collectors.toCollection(ArrayList::new));
        List<Integer> post2 = Stream.of(1, 0, 0).collect(Collectors.toCollection(ArrayList::new));
        post.add(post1);
        post.add(post2);
        List<Integer> M = Stream.of(1, 0).collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Liste bornee : " + Outils.estBorne(P, T, pre, post, M));
    }
}
