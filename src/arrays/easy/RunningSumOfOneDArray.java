package arrays.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RunningSumOfOneDArray {
    public static int[] runningSum(int[] nums) {
        int[] arr = new int[nums.length];
        int i = 0;
        while(i < nums.length) {
            if( i == 0) {
                arr[i] = nums[i];
            } else {
                arr[i] = arr[i - 1] + nums[i];
            }
            i++;
        }
        return arr;
    }
}

class TestRunningSumOfOneDArray {
    @Test
    public void runningSum() {
        int[] input = new int[] {1,2,3,4};
        int[] expected = new int[]{1,3,6,10};
        int[] output = RunningSumOfOneDArray.runningSum(input);
        assertArrayEquals(expected, output);
    }

    @Test
    public void runningSum1() {
        int[] input = new int[] {1,1,1,1,1};
        int[] expected = new int[]{1,2,3,4,5};
        int[] output = RunningSumOfOneDArray.runningSum(input);
        assertArrayEquals(expected, output);
    }
}
