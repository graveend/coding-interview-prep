package dp.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 *
 */
public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}

class TestLongestIncreasingSubsequence {
    @Test
    public void testLIS() {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int expected = 4;
        int output = LongestIncreasingSubsequence.lengthOfLIS(nums);
        assertEquals(expected, output);
    }

    @Test
    public void testLIS1() {
        int[] nums = new int[]{0,1,0,3,2,3};
        int expected = 4;
        int output = LongestIncreasingSubsequence.lengthOfLIS(nums);
        assertEquals(expected, output);
    }

    @Test
    public void testLIS2() {
        int[] nums = new int[]{7,7,7,7};
        int expected = 1;
        int output = LongestIncreasingSubsequence.lengthOfLIS(nums);
        assertEquals(expected, output);
    }

}
