/**
 * Class that prints the Collatz sequence starting from a given number.
 * @author Zeng Xianzhao
 */

public class Collatz {
/**
   * If n is even, return n/2
   * If n is odd, return n* 3+1
   * @param n 是现在的参数
   * @return 返回下一个序列数
   */
    public static int nextNumber(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return 3 * n + 1;
        }
        }


    public static void main(String[] args) {
        int n = 5;
        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

