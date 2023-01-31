package arrays.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/description/
 */
public class MinimumValueToGetPositiveStepByStepSum {
    public static int minStartValue(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++) {
            nums[i] += nums[i-1];
        }

        for(int num : nums) {
            min = Math.min(min, num);
        }
        return min >= 1 ? 1 : Math.abs(min) + 1;
    }
}

class TestMinimumValueToGetPositiveStepByStepSum {
    @Test
    public void testStartValue() {
        int[] nums = new int[]{-3,2,-3,4,2};
        int expected = 5;
        int output = MinimumValueToGetPositiveStepByStepSum.minStartValue(nums);
        assertEquals(expected,output);
    }

    @Test
    public void testStartValue1() {
        int[] nums = new int[]{1,2};
        int expected = 1;
        int output = MinimumValueToGetPositiveStepByStepSum.minStartValue(nums);
        assertEquals(expected,output);
    }

    @Test
    public void testStartValue2() {
        int[] nums = new int[]{1,-2,-3};
        int expected = 5;
        int output = MinimumValueToGetPositiveStepByStepSum.minStartValue(nums);
        assertEquals(expected,output);
    }

    @Test
    public void testStartValue3() {
        int[] nums = new int[]{2,3,5,-5,-1};
        int expected = 1;
        int output = MinimumValueToGetPositiveStepByStepSum.minStartValue(nums);
        assertEquals(expected,output);
    }
}
