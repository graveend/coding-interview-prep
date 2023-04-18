package dp.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/largest-divisible-subset/description/
 *
 *      | nums: | 1 | 2 | 3 | 8 |
 *      |-------|---|---|---|---|
 *      | dp    | 1 | 2 | 2 | 3 |
 *
 */
public class LargestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int[] dp = new int[nums.length];
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        Arrays.fill(dp, 1);

        int max = 1;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }

        int prev = -1;
        for(int i = nums.length-1; i >= 0; i--) {
            if(dp[i] == max && (prev == -1 || prev % nums[i] == 0)) {
                res.add(nums[i]);
                max--;
                prev = nums[i];
            }
        }
        return res;
    }
}

class TestLargestDivisibleSubset {
    @Test
    public void testLargestSubset() {
        int[] nums = new int[]{1,2,3, 8};
        List<Integer> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(8,2,1));
        List<Integer> output = LargestDivisibleSubset.largestDivisibleSubset(nums);
        assertTrue(output.containsAll(expected));
    }

    @Test
    public void testLargestSubset1() {
        int[] nums = new int[]{1};
        List<Integer> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(1));
        List<Integer> output = LargestDivisibleSubset.largestDivisibleSubset(nums);
        assertTrue(output.containsAll(expected));
    }
}
