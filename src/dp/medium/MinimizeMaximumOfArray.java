package dp.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/minimize-maximum-of-array/description/
 */
public class MinimizeMaximumOfArray {
    public static int minimizeArrayValue(int[] nums) {
        long res = 0, total = 0;
        for(int i = 0; i < nums.length; i++) {
            total += nums[i];
            res = Math.max(res,  (total + i)/(i+1));
        }
        return  (int) res;
    }
}

class TestMinimizeMaximumOfArray {

    @Test
    public void testArray() {
        int[] nums = new int[]{10,1};
        int expected = 10;
        int output = MinimizeMaximumOfArray.minimizeArrayValue(nums);
        assertEquals(expected, output);
    }

    @Test
    public void testArray1() {
        int[] nums = new int[]{3,7,1,6,5};
        int expected = 5;
        int output = MinimizeMaximumOfArray.minimizeArrayValue(nums);
        assertEquals(expected, output);
    }
}
