package arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * https://leetcode.com/problems/container-with-most-water/
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 *
 */
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxArea = 0;
        while(i < j) {
            int minHeight = Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, minHeight*(j-i) );
            if( height[i] < height[j]) {
                i++;
            } else if( height[i] > height[j]) {
                j--;
            } else {
                i++;
                j--;
            }

        }
        return maxArea;

    }

}

class TestContainerWithMostWater {

    @Test
    public void testMaxArea() {
        int[] input = new int[]{1,8,6,2,5,4,8,3,7};
        int actual = ContainerWithMostWater.maxArea(input);
        int expected = 49;
        assertEquals(actual, expected);
    }

    @Test
    public void testMaxAreaSameHeight() {
        int[] input = new int[]{1,1};
        int actual = ContainerWithMostWater.maxArea(input);
        int expected = 1;
        assertEquals(actual, expected);
    }
}
