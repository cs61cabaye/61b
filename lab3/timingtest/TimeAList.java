package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%15d %15.2f %15d %15.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList<Integer>  Ns = new AList<>();
        AList<Integer>  opCounts = new AList<>();
        AList<Double> times = new AList<>();

        int[] COUNT = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 256000};
        for (int i :  COUNT)
            testAlist(i, Ns, times, opCounts);

        printTimingTable(Ns, times, opCounts);
    }
    private static void testAlist(int Count, AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts){
        AList<Integer> baseAlist = new AList<>();
        for (int i = 0; i < 100; i++)
            baseAlist.addLast(i);

        Stopwatch sw = new Stopwatch();
        for (int i = 0; i < Count; i++)
            baseAlist.addLast(1);
        double timeInSeconds = sw.elapsedTime();
        Ns.addLast(Count);
        opCounts.addLast(Count);
        times.addLast(timeInSeconds);
    }
}
