package dp.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
 *
 */
public class MaxLengthOfRepeatedSubarray {
    public static int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(nums1[i] == nums2[j]) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                    max = Math.max(dp[i+1][j+1], max);
                }
            }
        }
        return max;
    }
}

class TestMaxLengthOfRepeatedSubarray {
    @Test
    public void testMaxSubarray() {
        int[] nums1 = new int[]{1,2,3,2,1}, nums2 = new int[]{3,2,1,4,7};
        int expected = 3;
        int output = MaxLengthOfRepeatedSubarray.findLength(nums1,nums2);
        assertEquals(expected,output);
    }

    @Test
    public void testMaxSubarray1() {
        int[] nums1 = new int[]{0,0,0,0,0}, nums2 = new int[]{0,0,0,0,0};
        int expected = 5;
        int output = MaxLengthOfRepeatedSubarray.findLength(nums1,nums2);
        assertEquals(expected,output);
    }
}
