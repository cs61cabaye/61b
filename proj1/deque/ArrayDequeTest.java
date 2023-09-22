package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import java.util.Iterator;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
public class ArrayDequeTest {
    @Test
    public void testAdd() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        for (int i = 0; i < 2000; i++){
            ad1.addFirst(i);
        }
        ad1.printDeque();

        for (int i = 0; i < 2002; i++){
            ad1.removeLast();
        }
        ad1.printDeque();

        ArrayDeque<Integer> ad2 = new ArrayDeque<>();
        for (int i = 0; i < 200; i++){
            ad2.addLast(i);
        }
        ad2.printDeque();

        for (int i = 0; i < 199; i++){
            ad2.removeFirst();
        }
        ad2.printDeque();
    }

    @Test
    public void randomizedTest(){
        ArrayDeque<Integer> L = new ArrayDeque<>();
        LinkedListDeque<Integer> B = new LinkedListDeque<>();
        int N = 50000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size1 = L.size();
                int size2 = B.size();
                Assert.assertEquals(size1, size2);
            } else if (operationNumber == 2) {
                if (L.size() >0 && B.size() > 0) {
                    int rlast1 = L.removeLast();
                    int rlast2 = B.removeLast();
                    Assert.assertEquals(rlast1, rlast2);
                }
            }
        }
    }

    @Test
    public void testTwo(){
        LinkedListDeque<Integer> lD1 = new LinkedListDeque<>();
        ArrayDeque<Integer> Ad1 = new ArrayDeque<>();

        for (int i = 0; i < 10000; i++){
            lD1.addLast(i);
            Ad1.addLast(i);
        }
        Assert.assertEquals(lD1.toString(), Ad1.toString());

        for (int i = 0; i < 5000; i++){
            lD1.removeLast();
            Ad1.removeLast();
        }
        Assert.assertEquals(lD1.toString(), Ad1.toString());

        for (int i = 0; i < 5000; i++){
            lD1.addFirst(i);
            Ad1.addFirst(i);
        }
        Assert.assertEquals(lD1.toString(), Ad1.toString());
    }

    @Test
    public void  testIter(){
        ArrayDeque<Integer> lld5 = new ArrayDeque<Integer>();
        for (int i = 0; i < 200; i++) {
            lld5.addLast(i);
        }
        lld5.printDeque();
        for (Iterator<Integer> it = lld5.iterator(); it.hasNext();) {
            System.out.print(it.next());
            System.out.print(" ");
        }
        System.out.println(" ");
    }

    @Test
    public void testResize(){
        ArrayDeque<Integer> lld5 = new ArrayDeque<Integer>();
        for (int i = 0; i < 200; i++) {
            lld5.addLast(i);
        }
        lld5.resizeItems(2000);
        lld5.resizeItems(200);
        lld5.printDeque();

        lld5 = new ArrayDeque<Integer>();
        for (int i = 0; i < 10; i++) {
            lld5.addLast(i);
        }
        for (int i = 0; i < 190; i++) {
            lld5.addFirst(i);
        }
        lld5.printDeque();
        lld5.resizeItems(2000);
        lld5.resizeItems(300);
        lld5.printDeque();

    }
}
