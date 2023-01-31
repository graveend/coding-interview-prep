package arrays.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/find-the-middle-index-in-array/description/
 */
public class FindMiddleIndexInArray {
    public static int findMiddleIndex(int[] nums) {
        int total = 0, leftSum = 0;
        for(int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        for(int i = 0; i < nums.length; i++) {
            if( leftSum * 2 == total - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}

class TestFindMiddleIndexInArray {

    @Test
    public void testIndex() {
        int[] nums = new int[]{2,3,-1,8,4};
        int expected = 3;
        int output = FindMiddleIndexInArray.findMiddleIndex(nums);
        assertEquals(expected,output);
    }

    @Test
    public void testIndex1() {
        int[] nums = new int[]{1,-1,4};
        int expected = 2;
        int output = FindMiddleIndexInArray.findMiddleIndex(nums);
        assertEquals(expected,output);
    }

    @Test
    public void testIndex2() {
        int[] nums = new int[]{2,5};
        int expected = -1;
        int output = FindMiddleIndexInArray.findMiddleIndex(nums);
        assertEquals(expected,output);
    }
}
