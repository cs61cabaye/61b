package IntList;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
public class Disc03 {

    public static void fillGrid(int[] LL, int[] UR, int[][] S) {
        int N = S.length;
        int kL, kR;
        kL = kR = 0;

        for (int i = 0; i < N; i++){
            for (int j = 0; j < S[i].length; j++){
                if(i != j)
                {
                    if (j > i){
                        S[i][j] = UR[kR++];
                    } else {
                        S[i][j] = LL[kL++];
                    }
                }
            }
        }
    }

    @Test
    public void testFG()
    {
        int[] LL = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0 };
        int[] UR = { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
        int[][] S = {
                { 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0}
        };
        fillGrid(LL, UR, S);
        int[][] N = {
                { 0, 11, 12, 13, 14 },
                { 1, 0, 15, 16, 17 },
                { 2, 3, 0, 18, 19 },
                { 4, 5, 6, 0, 20 },
                { 7, 8, 9, 10, 0 }
        };
        Assert.assertArrayEquals( N, S );
    }

    public static IntList[] partition(IntList lst, int k) {
        IntList[] array = new IntList[k];
        int index = 0;
        IntList L = lst;
        while (L != null) {
            if (array[index] == null) {
                array[index]= L;
            }
            else {
                IntList p = array[index];
                while (p.rest != null){
                    p = p.rest;
                }
                p.rest = L;
            }

            index = (index + 1) % k;
            IntList tmp = L;
            L = L.rest;
            tmp.rest = null;
        }
        return array;
    }

    @Test
    public void testpartition(){
        IntList lst = IntList.of( 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25);
        IntList[] a = partition(lst, 3);
        for (IntList i : a){
            System.out.println(i.toString());
        }
    }
}
