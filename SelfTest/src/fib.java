public class fib {
    public static int fib2(int n, int k, int f0, int f1) {
        if (n == k) {
            return f1;
        }

    return fib2(n, k+1, f1, f1+f0);
}

    public static void main(String[] args) {
        System.out.println(fib.fib2(6,1,0,1));
    }
}