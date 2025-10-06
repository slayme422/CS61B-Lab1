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
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();



        int n=1000;

        while (n <= 700000) {
            AList<Integer> a1 = new AList<>();
            Stopwatch sw = new Stopwatch();

            //记录n次调用addLast消耗的时间
            for(int i=0; i<n;i++) {
                a1.addLast(10);

            }
            double time=sw.elapsedTime();

            Ns.addLast(n);
            times.addLast(time);
            opCounts.addLast(n);


            n=n*2;
        }
        printTimingTable(Ns, times, opCounts);

    }
}
