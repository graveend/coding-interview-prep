package arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Given an array of integers, return the indices of the 2 number that add up to the given target
 */
public class TwoSum {

    /**
     * Time: O(n), Space: O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (map.get(value) == null) {
                map.put(nums[i], i);
            } else {

                return new int[]{map.get(value), i};

            }
        }
        return new int[]{};
    }
}

class TestTwoSum {
    @Test
    @DisplayName("Test sample input from leetcode")
    public void testTwoSum() {
        int[] input = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] expected = new int[]{0, 1};
        int[] actual = TwoSum.twoSum(input, target);
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Test without inputs")
    public void testTwoSumEmptyInput() {
        int[] input = new int[]{};
        int target = 9;
        int[] expected = new int[]{};
        int[] actual = TwoSum.twoSum(input, target);
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Test target not found")
    public void testTwoSumTargetNotFound() {
        int[] input = new int[]{2, 7, 11, 15};
        int target = 200;
        int[] expected = new int[]{};
        int[] actual = TwoSum.twoSum(input, target);
        assertArrayEquals(expected, actual);
    }
}
