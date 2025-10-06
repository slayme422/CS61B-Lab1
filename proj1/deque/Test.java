import deque.AList;
import deque.LinkedListDeque;
import deque.StopWatch;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        int n = 500;

        AList<Double> times = new AList<>();
        AList<Integer> NS = new AList<>();
        AList<Integer> OC = new AList<>();

        while (n <= 128000) {
            LinkedListDeque<Integer> as = new LinkedListDeque<>();
            for (int i = 0; i < n; i++) {
                as.addLast(10);
            }

            StopWatch sw = new StopWatch();
            for (int i = 0; i < 5000000; i++) {
                as.addLast(10);
            }
            double time = sw.elapsedTime();

            times.addLast(time);
            NS.addLast(n);
            OC.addLast(5000000);

            n = n * 2;
        }

        printingTable(NS, times, OC);
    }

    public static void printingTable(AList<Integer> NS, AList<Double> times, AList<Integer> OperationCalls) {
        System.out.printf("%12s%12s%12s\n", "N", "times(s)", "OC");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < NS.size(); i++) {
            System.out.printf("|%12d|%12.6f|%12d\n", NS.get(i), times.get(i), OperationCalls.get(i));
        }
    }
}