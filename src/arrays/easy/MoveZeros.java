package arrays.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/move-zeroes/description/
 */
public class MoveZeros {
    public static void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while(j < nums.length) {
            // i -> 0
            while( i < nums.length && nums[i] != 0) {
                i++;
            }

            // j -> non 0
            while( j < nums.length && nums[j] == 0) {
                j++;
            }

            if(i < j && i < nums.length && j < nums.length) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j++;
            } else {
                j++;
            }
        }
    }
}

class TestMoveZeros {
    @Test
    public void testMoveZeros() {
        int[] input = new int[]{0,1,0,3,12};
        int[] expected =  new int[]{1,3,12,0,0};
        MoveZeros.moveZeroes(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testMoveZeros1() {
        int[] input = new int[]{0};
        int[] expected =  new int[]{0};
        MoveZeros.moveZeroes(input);
        assertArrayEquals(expected, input);
    }
}
