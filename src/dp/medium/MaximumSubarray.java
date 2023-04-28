package dp.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/maximum-subarray/?envType=study-plan&id=dynamic-programming-i
 *
 * Kadane's algorithm
 */
public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(sum < 0 ) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            max = Math.max( max, sum);
        }
        return max;
    }
}

class TestMaximumSubarray {
    @Test
    public void testMaxSubArray() {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int expected = 6;
        int output = MaximumSubarray.maxSubArray(nums);
        assertEquals(expected, output);
    }

    @Test
    public void testMaxSubArray1() {
        int[] nums = new int[]{1};
        int expected = 1;
        int output = MaximumSubarray.maxSubArray(nums);
        assertEquals(expected, output);
    }
}
