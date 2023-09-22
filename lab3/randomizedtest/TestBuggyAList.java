package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> anr = new AListNoResizing<>();
        BuggyAList<Integer> ba = new BuggyAList<>();
        anr.addLast(4);
        anr.addLast(5);
        anr.addLast(6);

        ba.addLast(4);
        ba.addLast(5);
        ba.addLast(6);

        assertEquals(anr.removeLast(), ba.removeLast());
        assertEquals(anr.removeLast(), ba.removeLast());
        assertEquals(anr.removeLast(), ba.removeLast());
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();
        int N = 5000;
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
                    int glast1 = L.getLast();
                    int glast2 = B.getLast();
                    Assert.assertEquals(glast1, glast2);
                    int rlast1 = L.removeLast();
                    int rlast2 = B.removeLast();
                    Assert.assertEquals(rlast1, rlast2);
                }
            }
        }
    }

}
