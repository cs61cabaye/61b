package deque;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class MaxArrayDequeTest {

    @Test
    public void testInt() {
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 < o2) ? 1 : 0;
            }
        };
        MaxArrayDeque<Integer> mad1 = new MaxArrayDeque<>(c);
        for (int i = 0; i < 100; i++)
            mad1.addLast(StdRandom.uniform(0, 100000));

        mad1.printDeque();
        System.out.println(mad1.max());

        Comparator<String> s = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        MaxArrayDeque<String> mad2 = new MaxArrayDeque<>(s);
        String[] sentences = "Z za A There are no runtime requirements on these additional methods, we only care about the correctness of your answer. Sometimes, there might be multiple elements in the MaxArrayDeque that are all equal and hence all the max: in in this case, you can return any of them and they will be considered correct.".split("\\s+");
        for (String ss : sentences)
            mad2.addLast(ss);
        System.out.println();
        Assert.assertEquals(mad2.max(), "za");
        Assert.assertEquals("A", mad2.max(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        }));
    }
}
