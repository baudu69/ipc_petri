import org.junit.jupiter.api.Test;
import outils.Outils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
public class OutilsTest {

    @Test
    void testTemoin() {
        List<Integer> un = List.of(0, 1);
        List<Integer> deux = List.of(0, 2);
        List<Integer> trois = List.of(1, 1);
        List<Integer> quatre = List.of(2, 2);
        assertTrue(Outils.temoin(un, deux));
        assertFalse(Outils.temoin(deux, deux));
        assertFalse(Outils.temoin(trois, un));
        assertFalse(Outils.temoin(quatre, trois));
    }

    @Test
    void testAlgo1() {
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
        assertTrue(Outils.estBorne(P, T, pre, post, M));
    }

    @Test
    void testAlgo2() {
        int P = 2;
        int T = 3;
        List<Integer> pre1 = Stream.of(1, 0, 0).collect(Collectors.toCollection(ArrayList::new));
        List<Integer> pre2 = Stream.of(0, 1, 1).collect(Collectors.toCollection(ArrayList::new));
        List<List<Integer>> pre = new ArrayList<>();
        pre.add(pre1);
        pre.add(pre2);
        List<List<Integer>> post = new ArrayList<>();
        List<Integer> post1 = Stream.of(0, 1, 0).collect(Collectors.toCollection(ArrayList::new));
        List<Integer> post2 = Stream.of(2, 0, 0).collect(Collectors.toCollection(ArrayList::new));
        post.add(post1);
        post.add(post2);
        List<Integer> M = Stream.of(1, 0).collect(Collectors.toCollection(ArrayList::new));
        assertFalse(Outils.estBorne(P, T, pre, post, M));
    }
}
