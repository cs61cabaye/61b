package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        AList<Integer>  Ns = new AList<>();
        AList<Integer>  opCounts = new AList<>();
        AList<Double> times = new AList<>();

        int[] COUNT = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};
        for (int i :  COUNT)
            testSLList(i, Ns, times, opCounts);

        printTimingTable(Ns, times, opCounts);
    }

    private static void testSLList(int Count, AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts){
        SLList<Integer> baseList = new SLList<>();
        for (int i = 0; i < Count; i++)
            baseList.addLast(1);

        Stopwatch sw = new Stopwatch();
        for (int i = 0; i < 10000; i++)
            baseList.getLast();
        double timeInSeconds = sw.elapsedTime();
        Ns.addLast(Count);
        opCounts.addLast(10000);
        times.addLast(timeInSeconds);
    }

}
