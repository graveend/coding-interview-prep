package dp.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 *
 *  DP[N] = min( DP[N_1] + cost[N-1] , DP[N-2] + cost[N-2])
 */
public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        int a = 0, b = 0;
        for(int i = 2; i <= cost.length; i++) {
            int curr = Math.min(cost[i-1] + b , cost[i-2] + a);
            a = b;
            b = curr;
        }
        return b;
    }
}

class TestMinCostClimbingStairs {
    @Test
    public void testJumps() {
        int[] cost = new int[]{10,15,20};
        int expected = 15;
        int output = MinCostClimbingStairs.minCostClimbingStairs(cost);
        assertEquals(expected,output);
    }

    @Test
    public void testJumps1() {
        int[] cost = new int[]{1,100,1,1,1,100,1,1,100,1};
        int expected = 6;
        int output = MinCostClimbingStairs.minCostClimbingStairs(cost);
        assertEquals(expected,output);
    }
}
