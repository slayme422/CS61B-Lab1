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
        // TODO: YOUR CODE HERE
        //这次的size是1000代表n
        int n=1000;
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        while (n<=128000){


            SLList<Integer> s1=new SLList<>();
            for (int i = 0; i < n; i++) {
                s1.addLast(10);
            }
            Stopwatch sw=new Stopwatch();

            for (int i = 0; i < 10000; i++) {
                s1.addLast(10);
            }

            double time=sw.elapsedTime();

            times.addLast(time);
            Ns.addLast(n);
            opCounts.addLast(10000);

            n=n*2;
        }
        printTimingTable(Ns, times, opCounts);
    }

}
