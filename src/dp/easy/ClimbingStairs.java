package dp.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClimbingStairs {

    public static int climbStairsDp(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static int climbStairs(int n) {
        int prev1 = 1, prev2 = 1;
        for(int i = 2; i <= n; i++) {
            int temp = prev1 + prev2;
            prev1 = prev2;
            prev2 = temp;
        }
        return prev2;
    }

}

class TestClimbingStairs {

    @Test
    public void climbStairsDp() {
        int n = 3;
        int expected = 3;
        int output = ClimbingStairs.climbStairsDp(n);
        assertEquals(expected,output);
    }

    @Test
    public void climbStairsDp1() {
        int n = 2;
        int expected = 2;
        int output = ClimbingStairs.climbStairsDp(n);
        assertEquals(expected,output);
    }

    @Test
    public void climbStairs() {
        int n = 3;
        int expected = 3;
        int output = ClimbingStairs.climbStairs(n);
        assertEquals(expected,output);
    }

    @Test
    public void climbStairs1() {
        int n = 2;
        int expected = 2;
        int output = ClimbingStairs.climbStairs(n);
        assertEquals(expected,output);
    }

}
