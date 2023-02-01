package arrays.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/description/
 */
public class SumOfAbsoluteDifferenceOfSortedArray {
    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        int res[] = new int[n];
        // calculate prefix sum
        prefixSum[0] = nums[0];
        for(int i = 1;i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        // calculate result

        res[0] = (prefixSum[n-1] - prefixSum[0]) - ((n-1)*nums[0]);
        for(int i = 1; i < n; i++) {
            res[i] = ((i) * nums[i]) - prefixSum[i-1] + (prefixSum[n-1] - prefixSum[i]) - ((n-i-1)*nums[i]);
        }
        return res;
    }
}

class TestSumOfAbsoluteDifferenceOfSortedArray {
    @Test
    public void testGetSumAbsoluteDifferences() {
        int[] nums = new int[]{2,3,5};
        int[] expected = new int[]{4,3,5};
        int[] output = SumOfAbsoluteDifferenceOfSortedArray.getSumAbsoluteDifferences(nums);
        assertArrayEquals(expected,output);
    }

    @Test
    public void testGetSumAbsoluteDifferences1() {
        int[] nums = new int[]{1,4,6,8,10};
        int[] expected = new int[]{24,15,13,15,21};
        int[] output = SumOfAbsoluteDifferenceOfSortedArray.getSumAbsoluteDifferences(nums);
        assertArrayEquals(expected,output);
    }
}
