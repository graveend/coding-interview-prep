package dp.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 *
 *  Ex: [1,5,6]  ans = true
 *  1+5+6 = 12
 *  12/2 = 6  ---> If 6 is present in the dp table that implies we can partition it.
 *
 *               0  1   2   3   4   5   6
 *              ____________________________--
 *          [] |T   F   F   F   F   F   F
 *         [1] |T   T   F   F   F   F   F
 *        [1,5]|T   T   F   F   F   T   T
 *      [1,5,6]|T   T   F   F   F   T   T
 *
 *      DP[i][searchValue] = DP[i-1][searchValue]   ||    DP[i-1][searchValue- nums[i-1]]
 *                              (Exclude)                      (Include)
 *
 */
public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {
        int total = 0;
        for(int num: nums) {
            total += num;
        }
        if(total % 2 != 0) return false;
        int required = total/2;
        boolean[][] dp = new boolean[nums.length + 1][required + 1];

        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        for(int i = 1; i <= nums.length; i++) {
            for(int searchSum = 1; searchSum <= required; searchSum++) {
                dp[i][searchSum] = dp[i-1][searchSum]; // exclude curr element
                if(searchSum-nums[i-1] >= 0) {
                    // If we include the current elem then check dp[i-1][searchSum-nums[i-1]] is available
                    dp[i][searchSum] = dp[i][searchSum] || dp[i-1][searchSum-nums[i-1]];
                }

            }
        }
        return dp[nums.length][required];
    }
}

class TestPartitionEqualSubsetSum {
    @Test
    public void testPartition() {
        int[] nums = new int[]{1,5,6};
        boolean expected = true;
        boolean output = PartitionEqualSubsetSum.canPartition(nums);
        assertEquals(expected, output);
    }

    @Test
    public void testPartition1() {
        int[] nums = new int[]{1,2,3,5};
        boolean expected = false;
        boolean output = PartitionEqualSubsetSum.canPartition(nums);
        assertEquals(expected, output);
    }
}
