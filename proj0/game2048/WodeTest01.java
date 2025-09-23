package game2048;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.Arrays;

public class WodeTest01 {
    public static void main(String[] args) {
        boolean[] merged = new boolean[4];
        merged[0]=true;
        merged[1]=true;
        for (boolean b : merged) {
            System.out.println(b);
        }
    }
}
