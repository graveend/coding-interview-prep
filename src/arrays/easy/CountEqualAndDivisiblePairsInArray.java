package arrays.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/description/
 */
public class CountEqualAndDivisiblePairsInArray {
    public static int countPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> numberToCount = new HashMap<>();
        int count = 0;
        for( int i = 0; i < nums.length; i++) {
            if(!numberToCount.containsKey(nums[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                numberToCount.put(nums[i],list);
            } else {

                List<Integer> indexes = numberToCount.get(nums[i]);
                for(Integer idx: indexes) {
                    if((idx * i) % k == 0) {
                        count++;
                    }
                }
                indexes.add(i);
                numberToCount.put(nums[i],indexes);
            }
        }
        return count;
    }
}

class TestCountEqualAndDivisiblePairsInArray {

    @Test
    public void testPairs() {
        int[] nums = new int[]{3,1,2,2,2,1,3};
        int k = 2;
        int expected = 4;
        int output = CountEqualAndDivisiblePairsInArray.countPairs(nums,k);
        assertEquals(expected,output);
    }

    @Test
    public void testPairs1() {
        int[] nums = new int[]{1,2,3,4};
        int k = 1;
        int expected = 0;
        int output = CountEqualAndDivisiblePairsInArray.countPairs(nums,k);
        assertEquals(expected,output);
    }
}
