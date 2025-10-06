package deque;

public class StopWatch {
    private long start=System.currentTimeMillis();;

    public StopWatch() {

    }

    public double elapsedTime() {
        return (System.currentTimeMillis() - start) / 1000.0;
    }

    public void reset() {
        this.start = System.currentTimeMillis();
    }
}