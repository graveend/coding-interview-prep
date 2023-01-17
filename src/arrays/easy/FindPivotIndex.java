package arrays.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/find-pivot-index/description/
 */
public class FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int leftSum = 0;
        int rightSum = sum;
        for(int i = 0; i < nums.length; i++) {
            rightSum = rightSum - nums[i];
            if(leftSum == rightSum) {
                return i;
            }
            leftSum = leftSum + nums[i];
        }
        return -1;
    }
}

class TestFindPivotIndex {

    @Test
    public void testPivot1() {
        int[] nums = new int[]{1,7,3,6,5,6};
        int expected = 3;
        int output = FindPivotIndex.pivotIndex(nums);
        assertEquals(expected, output);
    }

    @Test
    public void testPivot2() {
        int[] nums = new int[]{1,2,3};
        int expected = -1;
        int output = FindPivotIndex.pivotIndex(nums);
        assertEquals(expected, output);
    }

    @Test
    public void testPivot3() {
        int[] nums = new int[]{2,1,-1};
        int expected = 0;
        int output = FindPivotIndex.pivotIndex(nums);
        assertEquals(expected, output);
    }

}
