package arrays.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
 */
public class KDifferentPairsInArray {
    public static int findPairs(int[] nums, int k) {
        Map<Integer,Integer> integerToCount = new HashMap<>();
        int count = 0;
        for(int num : nums) {
            integerToCount.put(num, integerToCount.getOrDefault(num,0)+1);
        }

        for(int key: integerToCount.keySet()) {
            if( (k > 0 && integerToCount.containsKey(k+key)) || (k==0 && integerToCount.get(key) > 1) ) {
                count++;
            }
        }
        return count;
    }
}

class TestKDifferentPairsInArray {

    @Test
    public void testPairsInArray() {
        int[] nums = new int[]{3,1,4,1,5};
        int k = 2;
        int expected = 2;
        int output = KDifferentPairsInArray.findPairs(nums, k);
        assertEquals(expected,output);
    }

    @Test
    public void testPairsInArray1() {
        int[] nums = new int[]{1,2,3,4,5};
        int k = 1;
        int expected = 4;
        int output = KDifferentPairsInArray.findPairs(nums, k);
        assertEquals(expected,output);
    }
}
