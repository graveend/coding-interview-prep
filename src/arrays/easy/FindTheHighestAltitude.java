package arrays.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/find-the-highest-altitude/description/
 */
public class FindTheHighestAltitude {
    public static int largestAltitude(int[] gain) {
        Integer max = 0;
        int sum = 0;
        for(int i = 0; i < gain.length; i++) {
            sum += gain[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}

class TestFindTheHighestAltitude {
    @Test
    public void testAltitude() {
        int[] gain = new int[]{-5,1,5,0,-7};
        int expected = 1;
        int output = FindTheHighestAltitude.largestAltitude(gain);
        assertEquals(expected,output);
    }

    @Test
    public void testAltitude1() {
        int[] gain = new int[]{-4,-3,-2,-1,4,3,2};
        int expected = 0;
        int output = FindTheHighestAltitude.largestAltitude(gain);
        assertEquals(expected,output);
    }
}
