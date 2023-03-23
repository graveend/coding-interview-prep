package dp.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/n-th-tribonacci-number/description/
 */
public class TribonacciNumber {
    public static int tribonacci(int n) {
         int[] dp = new int[n+1];
         Arrays.fill(dp, -1);
         return dfs(n, dp);
    }

    private static int dfs(int n, int[] dp) {
        if( n < 2 ) return n;
        if( n == 2) return 1;

        if(dp[n] != -1) return dp[n];

        return dp[n] = dfs(n-1, dp) + dfs(n-2, dp) + dfs(n-3, dp);
    }


    public static int iterative(int n) {
        int a = 0, b = 1, c = 1;
        if(n < 2) return n;
        if(n ==2) return 1;
        int res = 0;
        for(int i = 3; i <= n; i++) {
            res = a+b+c;
            a = b;
            b = c;
            c = res;
        }
        return res;
    }
}

class TestTribonacciNumber {
    @Test
    public void testTribonacci() {
        int n = 4;
        int expected = 4;
        int output = TribonacciNumber.tribonacci(n);
        assertEquals(expected, output);
    }

    @Test
    public void testTribonacci1() {
        int n = 25;
        int expected = 1389537;
        int output = TribonacciNumber.tribonacci(n);
        assertEquals(expected, output);
    }

    @Test
    public void testTribonacci2() {
        int n = 25;
        int expected = 1389537;
        int output = TribonacciNumber.iterative(n);
        assertEquals(expected, output);
    }
}
