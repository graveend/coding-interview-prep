package dp.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/jump-game/description/
 */
public class JumpGame {
    public static boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for(int i = 0; i < nums.length; i++) {
            if(dp[i] == true) {
                int j = i;
                while(j < nums.length && j <= (i + nums[i])) {
                    dp[j] = true;
                    j++;
                }
            }
        }
        return dp[nums.length-1];
    }

    public static boolean canJumpUsingMaxReach(int[] nums) {
        int maxReach = 0;
        for(int i = 0; i < nums.length; i++) {
            if( i > maxReach) return false;
            if(maxReach == nums.length-1) return true;
            maxReach = Math.max(maxReach, i+nums[i]);
        }
        return false;
    }
}

class TestJumpGame {
    @Test
    public void testGame() {
        int[] nums = new int[]{2,3,1,1,4};
        boolean expected = true;
        boolean output = JumpGame.canJump(nums);
        assertEquals(expected, output);
    }

    @Test
    public void testGame1() {
        int[] nums = new int[]{3,2,1,0,4};
        boolean expected = false;
        boolean output = JumpGame.canJump(nums);
        assertEquals(expected, output);
    }

    @Test
    public void testGame2() {
        int[] nums = new int[]{2,3,1,1,4};
        boolean expected = true;
        boolean output = JumpGame.canJumpUsingMaxReach(nums);
        assertEquals(expected, output);
    }

    @Test
    public void testGame3() {
        int[] nums = new int[]{3,2,1,0,4};
        boolean expected = false;
        boolean output = JumpGame.canJumpUsingMaxReach(nums);
        assertEquals(expected, output);
    }
}
