package arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * IMP: https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
    /**
     * O(n) time, O(1) space
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;
        while(left < right) {
            if(height[left] < height[right]) {
                if(height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    ans += leftMax - height[left];
                }
                left++;
            } else {
                if(height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    ans += rightMax - height[right];
                }
                right--;
            }
        }
        return ans;
    }

}

class TestTrappingRainWater {

    @Test
    public void testTrap() {
        int[] height = new int[]{4,2,0,3,2,5};
        int expected = 9;
        int actual = TrappingRainWater.trap(height);
        assertEquals(expected, actual);
    }

    @Test
    public void testTrapScenario2() {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int expected = 6;
        int actual = TrappingRainWater.trap(height);
        assertEquals(expected, actual);
    }

    @Test
    public void testTrapWithEmptyWater() {
        int[] height = new int[]{0,1,0};
        int expected = 0;
        int actual = TrappingRainWater.trap(height);
        assertEquals(expected, actual);
    }
}
