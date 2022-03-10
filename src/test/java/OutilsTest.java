import org.junit.jupiter.api.Test;
import outils.Outils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
public class OutilsTest {

    @Test
    void testExo1Figure1() {
        //Pre
        List<List<Integer>> pre = new ArrayList<>();
        pre.add(Stream.of(1, 0, 0, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        pre.add(Stream.of(0, 1, 0, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        pre.add(Stream.of(0, 0, 0, 0, 1).collect(Collectors.toCollection(ArrayList::new)));
        pre.add(Stream.of(0, 0, 1, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        pre.add(Stream.of(0, 0, 0, 1, 1).collect(Collectors.toCollection(ArrayList::new)));
        //Post
        List<List<Integer>> post = new ArrayList<>();
        post.add(Stream.of(0, 0, 0, 0, 1).collect(Collectors.toCollection(ArrayList::new)));
        post.add(Stream.of(1, 0, 0, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        post.add(Stream.of(0, 1, 0, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        post.add(Stream.of(1, 0, 0, 1, 0).collect(Collectors.toCollection(ArrayList::new)));
        post.add(Stream.of(0, 0, 1, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        //M
        List<Integer> M = Stream.of(1, 0, 0, 0, 0).collect(Collectors.toCollection(ArrayList::new));

        int P = pre.size();
        int T = pre.get(0).size();
        assertTrue(Outils.estBorne(P, T, pre, post, M));
    }

    @Test
    void testExo1Figure2() {
        //Pre
        List<List<Integer>> pre = new ArrayList<>();
        pre.add(Stream.of(1, 0, 0, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        pre.add(Stream.of(1, 1, 0, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        pre.add(Stream.of(0, 1, 0, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        pre.add(Stream.of(0, 0, 1, 0, 1).collect(Collectors.toCollection(ArrayList::new)));
        pre.add(Stream.of(0, 0, 0, 1, 1).collect(Collectors.toCollection(ArrayList::new)));
        //Post
        List<List<Integer>> post = new ArrayList<>();
        post.add(Stream.of(0, 0, 1, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        post.add(Stream.of(0, 0, 1, 1, 0).collect(Collectors.toCollection(ArrayList::new)));
        post.add(Stream.of(0, 0, 0, 1, 0).collect(Collectors.toCollection(ArrayList::new)));
        post.add(Stream.of(1, 0, 0, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        post.add(Stream.of(0, 1, 0, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        //M
        List<Integer> M = Stream.of(1, 1, 1, 0, 0).collect(Collectors.toCollection(ArrayList::new));

        int P = pre.size();
        int T = pre.get(0).size();
        assertTrue(Outils.estBorne(P, T, pre, post, M));
    }

    @Test
    void testExo1Figure3() {
        //Pre
        List<List<Integer>> pre = new ArrayList<>();
        pre.add(Stream.of(1, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        pre.add(Stream.of(0, 1, 1).collect(Collectors.toCollection(ArrayList::new)));
        //Post
        List<List<Integer>> post = new ArrayList<>();
        post.add(Stream.of(0, 1, 0).collect(Collectors.toCollection(ArrayList::new)));
        post.add(Stream.of(1, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        //M
        List<Integer> M = Stream.of(1,0).collect(Collectors.toCollection(ArrayList::new));

        int P = pre.size();
        int T = pre.get(0).size();
        assertTrue(Outils.estBorne(P, T, pre, post, M));
    }

    @Test
    void testExo1Figure4() {
        //Pre
        List<List<Integer>> pre = new ArrayList<>();
        pre.add(Stream.of(1, 0, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        pre.add(Stream.of(0, 1, 1, 0).collect(Collectors.toCollection(ArrayList::new)));
        pre.add(Stream.of(0, 0, 0, 1).collect(Collectors.toCollection(ArrayList::new)));
        //Post
        List<List<Integer>> post = new ArrayList<>();
        post.add(Stream.of(1, 1, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        post.add(Stream.of(0, 0, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        post.add(Stream.of(0, 0, 1, 1).collect(Collectors.toCollection(ArrayList::new)));
        //M
        List<Integer> M = Stream.of(0,1,0).collect(Collectors.toCollection(ArrayList::new));

        int P = pre.size();
        int T = pre.get(0).size();
        assertTrue(Outils.estBorne(P, T, pre, post, M));
    }

    @Test
    void testExo1Figure5() {
        //Pre
        List<List<Integer>> pre = new ArrayList<>();
        pre.add(Stream.of(1, 1).collect(Collectors.toCollection(ArrayList::new)));
        pre.add(Stream.of(0, 0).collect(Collectors.toCollection(ArrayList::new)));
        //Post
        List<List<Integer>> post = new ArrayList<>();
        post.add(Stream.of(0, 1).collect(Collectors.toCollection(ArrayList::new)));
        post.add(Stream.of(0, 1).collect(Collectors.toCollection(ArrayList::new)));
        //M
        List<Integer> M = Stream.of(1,0).collect(Collectors.toCollection(ArrayList::new));

        int P = pre.size();
        int T = pre.get(0).size();
        assertFalse(Outils.estBorne(P, T, pre, post, M));
    }

    @Test
    void testExo1Figure6() {
        //Pre
        List<List<Integer>> pre = new ArrayList<>();
        pre.add(Stream.of(5, 2, 0).collect(Collectors.toCollection(ArrayList::new)));
        pre.add(Stream.of(0, 1, 5).collect(Collectors.toCollection(ArrayList::new)));
        //Post
        List<List<Integer>> post = new ArrayList<>();
        post.add(Stream.of(2, 0, 5).collect(Collectors.toCollection(ArrayList::new)));
        post.add(Stream.of(3, 3, 0).collect(Collectors.toCollection(ArrayList::new)));
        //M
        List<Integer> M = Stream.of(4, 2).collect(Collectors.toCollection(ArrayList::new));

        int P = pre.size();
        int T = pre.get(0).size();
        assertTrue(Outils.estBorne(P, T, pre, post, M));
    }
}
