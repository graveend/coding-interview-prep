package dp.hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/description/
 */
public class MaxValueOfKCoinsFromPiles {
    static Integer[][] dp = null;
    public static int maxValueOfCoins(List<List<Integer>> piles, int k) {
        dp = new Integer[piles.size() + 1][k+1];
        return knapSack(piles, piles.size() - 1, k);
    }

    private static int knapSack(List<List<Integer>> piles, int pilePos, int requiredCoins) {
        if(pilePos < 0 || requiredCoins <= 0) return 0;

        if(dp[pilePos][requiredCoins] != null) return dp[pilePos][requiredCoins];

        // skip current pile
        int exclude = knapSack(piles, pilePos - 1, requiredCoins);

        // Include current pile
        int include = 0;
        int n = Math.min(piles.get(pilePos).size(), requiredCoins);
        for(int i = 0, sum = 0; i < n; i++) {
            sum += piles.get(pilePos).get(i);
            include = Math.max(sum + knapSack(piles, pilePos-1, requiredCoins-i-1), include);
        }
        int res = Math.max(exclude, include);
        dp[pilePos][requiredCoins] = res;
        return res;
    }
}

class TestMaxValueOfKCoinsFromPiles {
    @Test
    public void testMaxCoins() {
        List<List<Integer>> piles = Arrays.asList(Arrays.asList(1,100,3), Arrays.asList(7,8,9));
        int k = 2;
        int expected = 101;
        int output = MaxValueOfKCoinsFromPiles.maxValueOfCoins(piles,k);
        assertEquals(expected, output);
    }

    @Test
    public void testMaxCoins1() {
        List<List<Integer>> piles = Arrays.asList(Arrays.asList(100), Arrays.asList(100),Arrays.asList(100),Arrays.asList(1,1,300));
        int k = 3;
        int expected = 302;
        int output = MaxValueOfKCoinsFromPiles.maxValueOfCoins(piles,k);
        assertEquals(expected, output);
    }
}
