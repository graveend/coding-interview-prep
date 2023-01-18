package arrays.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/product-of-array-except-self/description/
 */
public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        arr[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            arr[i] = arr[i-1] * nums[i-1];
        }
        int product = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            product *= nums[i+1];
            arr[i] *= product;
        }
        return arr;
    }
}

class TestProductOfArrayExceptSelf {
    @Test
    public void testProductExceptSelf() {
        int[] nums = new int[]{1,2,3,4};
        int[] expected = new int[]{24,12,8,6};
        int[] output = ProductOfArrayExceptSelf.productExceptSelf(nums);
        assertArrayEquals(expected, output);
    }

    @Test
    public void testProductExceptSelf1() {
        int[] nums = new int[]{-1,1,0,-3,3};
        int[] expected = new int[]{0,0,9,0,0};
        int[] output = ProductOfArrayExceptSelf.productExceptSelf(nums);
        assertArrayEquals(expected, output);
    }
}
