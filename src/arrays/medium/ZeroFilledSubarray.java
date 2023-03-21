package arrays.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/number-of-zero-filled-subarrays/
 */
public class ZeroFilledSubarray {
    public static long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long res = 0;
        for(int i = 0; i < nums.length; i++ ) {
            if(nums[i] == 0) {
                count++;
                res += count;
            } else {
                count = 0;
            }
        }
        return res;
    }
}

class TestZeroFilledSubarray {

    @Test
    public void testZeroFilledSubarray() {
        int[] nums = new int[]{1,3,0,0,2,0,0,4};
        long expected = 6;
        long output = ZeroFilledSubarray.zeroFilledSubarray(nums);
        assertEquals(expected, output);

    }

    @Test
    public void testZeroFilledSubarray1() {
        int[] nums = new int[]{0,0,0,2,0,0};
        long expected = 9;
        long output = ZeroFilledSubarray.zeroFilledSubarray(nums);
        assertEquals(expected, output);

    }
}
