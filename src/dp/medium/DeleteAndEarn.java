package dp.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/delete-and-earn/description/
 *
 * HINT: Similar to Climbing Stairs and HouseRobber
 */
public class DeleteAndEarn {
    public static int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num: nums) {
            max = Math.max(max, num);
        }

        int[] freq = new int[max+1];
        for(int num: nums) {
            freq[num]++;
        }

        for(int i=2; i<freq.length; i++){
            int withElement = freq[i-2] + (i*freq[i]);
            int withoutElement = freq[i-1];
            freq[i] = Math.max(withElement, withoutElement);
        }

        return freq[max];
    }
}

class TestDeleteAndEarn {
    @Test
    public void testDeleteAndEarn() {
        int[] nums = new int[]{3,4,2};
        int expected = 6;
        int output = DeleteAndEarn.deleteAndEarn(nums);
        assertEquals(expected, output);
    }

    @Test
    public void testDeleteAndEarn1() {
        int[] nums = new int[]{2,2,3,3,3,4};
        int expected = 9;
        int output = DeleteAndEarn.deleteAndEarn(nums);
        assertEquals(expected, output);
    }
}
