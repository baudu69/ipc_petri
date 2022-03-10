import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import outils.Outils;
import outils.OutilsPont;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class OutilsTest {

    @Test
    void testExo1Figure1() {
        System.out.println("****Figure 1****");
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
        System.out.println("****Figure 2****");
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
        System.out.println("****Figure 3****");
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
        System.out.println("****Figure 4****");
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
        System.out.println("****Figure 5****");
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
        System.out.println("****Figure 6****");
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

    @Test
    void testExo2LEPONTDAVIGNON() {
        System.out.println("****Problème du pont****");
        //Pre
        List<List<Integer>> pre = new ArrayList<>();
        pre.add(Stream.of(10, 10, 10, 0, 0, 0, 0, 0, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        pre.add(Stream.of(5, 0, 0, 5, 5, 0, 0, 0, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        pre.add(Stream.of(0, 2, 0, 2, 0, 2, 0, 0, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        pre.add(Stream.of(0, 0, 1, 0, 1, 1, 0, 0, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        pre.add(Stream.of(1, 1, 1, 1, 1, 1, 0, 0, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        pre.add(Stream.of(0, 0, 0, 0, 0, 0, 10, 0, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        pre.add(Stream.of(0, 0, 0, 0, 0, 0, 0, 5, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        pre.add(Stream.of(0, 0, 0, 0, 0, 0, 0, 0, 2, 0).collect(Collectors.toCollection(ArrayList::new)));
        pre.add(Stream.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 1).collect(Collectors.toCollection(ArrayList::new)));
        pre.add(Stream.of(0, 0, 0, 0, 0, 0, 1, 1, 1, 1).collect(Collectors.toCollection(ArrayList::new)));
        pre.add(Stream.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        //Post
        List<List<Integer>> post = new ArrayList<>();
        post.add(Stream.of(0, 0, 0, 0, 0, 0, 10, 0, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        post.add(Stream.of(0, 0, 0, 0, 0, 0, 0, 5, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        post.add(Stream.of(0, 0, 0, 0, 0, 0, 0, 0, 2, 0).collect(Collectors.toCollection(ArrayList::new)));
        post.add(Stream.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 1).collect(Collectors.toCollection(ArrayList::new)));
        post.add(Stream.of(0, 0, 0, 0, 0, 0, 1, 1, 1, 1).collect(Collectors.toCollection(ArrayList::new)));
        post.add(Stream.of(10, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        post.add(Stream.of(5, 0, 0, 5, 5, 0, 0, 0, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        post.add(Stream.of(0, 2, 0, 2, 0, 2, 0, 0, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        post.add(Stream.of(0, 0, 1, 0, 1, 1, 0, 0, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        post.add(Stream.of(1, 1, 1, 1, 1, 1, 0, 0, 0, 0).collect(Collectors.toCollection(ArrayList::new)));
        post.add(Stream.of(10, 10, 10, 5, 5, 2, 10, 5, 2, 1).collect(Collectors.toCollection(ArrayList::new)));
        //M
        List<Integer> M = Stream.of(10, 5, 2, 1, 1, 0, 0, 0, 0, 0, 0).collect(Collectors.toCollection(ArrayList::new));

        int P = pre.size();
        int T = pre.get(0).size();
        assertTrue(OutilsPont.estBorneAVIGNON(P, T, pre, post, M));
    }

    @AfterEach
    void newLine() {
        System.out.println();
        System.out.println();
    }
}
