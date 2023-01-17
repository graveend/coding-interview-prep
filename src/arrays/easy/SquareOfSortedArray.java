package arrays.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/description/
 */
public class SquareOfSortedArray {
    public static int[] sortedSquares(int[] nums) {
        int i = 0, j = nums.length - 1, p = j;
        int[] arr = new int[nums.length];
        while(p >= 0) {
            if(Math.abs(nums[i]) > Math.abs(nums[j])) {
                arr[p] = nums[i] * nums[i];
                i++;
            } else {
                arr[p] = nums[j] * nums[j];
                j--;
            }
            p--;
        }
        return arr;
    }
}

class TestSquareOfSortedArray {

    @Test
    public void testSortedSquare1() {
        int[] input = new int[]{-4,-1,0,3,10};
        int[] expected = new int[]{0,1,9,16,100};
        int[] output = SquareOfSortedArray.sortedSquares(input);
        assertArrayEquals(expected,output);
    }

    @Test
    public void testSortedSquare2() {
        int[] input = new int[]{-7,-3,2,3,11};
        int[] expected = new int[]{4,9,9,49,121};
        int[] output = SquareOfSortedArray.sortedSquares(input);
        assertArrayEquals(expected,output);
    }
}
