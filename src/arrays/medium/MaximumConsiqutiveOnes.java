package arrays.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/max-consecutive-ones-iii/description/
 */
public class MaximumConsiqutiveOnes {
    public static int longestOnes(int[] nums, int k) {
        int i = 0, j;
        for (j = 0; j < nums.length; ++j) {
            if (nums[j] == 0) k--;
            if (k < 0 && nums[i++] == 0) k++;
        }
        return j - i;
    }
}

class TestMaximumConsiqutiveOnes {

    @Test
    public void testLongestOnes() {
        int[] nums = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int expected = 6;
        int output = MaximumConsiqutiveOnes.longestOnes(nums,k);
        assertEquals(expected,output);
    }

    @Test
    public void testLongestOnes1() {
        int[] nums = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        int expected = 10;
        int output = MaximumConsiqutiveOnes.longestOnes(nums,k);
        assertEquals(expected,output);
    }
}
