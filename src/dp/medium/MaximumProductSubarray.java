package dp.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/maximum-product-subarray/description/?envType=study-plan&id=dynamic-programming-i
 *
 *                       2,  3,  -2,   4
 *    prefixProduct:     2   6. -12  -48
 *    suffixProduct:    -48 -24 -8    4
 *      MAX               2.  6. -8.  4
 */
public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0, max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            l = ( l == 0 ? 1 : l) * nums[i];
            r = (r == 0 ? 1 : r) * nums[n-i-1];
            max = Math.max(max, Math.max(l,r));
        }
        return max;
    }
}

class TestMaximumProductSubarray {
    @Test
    public void testMaxProduct() {
        int[] nums = new int[]{2, 3, 0, -1};
        int expected = 6;
        int output = MaximumProductSubarray.maxProduct(nums);
        assertEquals(expected, output);
    }

    @Test
    public void testMaxProduct1() {
        int[] nums = new int[]{-2, 0, -1};
        int expected = 0;
        int output = MaximumProductSubarray.maxProduct(nums);
        assertEquals(expected, output);
    }
}
