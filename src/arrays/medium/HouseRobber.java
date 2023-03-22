package arrays.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/house-robber/description/
 *
 * Solution: https://leetcode.com/problems/house-robber/solutions/156523/from-good-to-great-how-to-approach-most-of-dp-problems/
 */
public class HouseRobber {
    public static int rob(int[] nums) {
        int prev1 = 0;
        int prev2 = 0;
        for(int num: nums) {
            int temp = prev1;
            prev1 = Math.max(prev2 + num , prev1);
            prev2 = temp;
        }
        return prev1;

    }
}

class TestHouseRobber {
    @Test
    public void testRob() {
        int[] nums = new int[]{1,2,3,1};
        int expected = 4;
        int output = HouseRobber.rob(nums);
        assertEquals(expected, output);
    }

    @Test
    public void testRob1() {
        int[] nums = new int[]{2,7,9,3,1};
        int expected = 12;
        int output = HouseRobber.rob(nums);
        assertEquals(expected, output);
    }
}
