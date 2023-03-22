package dp.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/perfect-squares/description/
 */
public class PerfectSquares {
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            dp[i] = i;
            for(int j = 1; (j*j) <= i; j++) {
                int sqr = j * j;
                dp[i] = Math.min(dp[i], 1 + dp[i - sqr]);
            }
        }

        return dp[n];
    }
}

class TestPerfectSquares {
    @Test
    public void testPerfectSquares() {
        int n = 12;
        int expected = 3;
        int output = PerfectSquares.numSquares(n);
        assertEquals(expected, output);
    }

    @Test
    public void testPerfectSquares1() {
        int n = 13;
        int expected = 2;
        int output = PerfectSquares.numSquares(n);
        assertEquals(expected, output);
    }
}
