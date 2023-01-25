package arrays.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * https://leetcode.com/problems/count-number-of-bad-pairs/description/
 *
 j - i != nums[j] - nums[i]
 j - nums[j] != i - nums[i]. ---> Invalid
 j - nums[j] == i - nums[i]. ---> Valid
 Total = Valid + Invalid
 Invalid = Total - Valid
 Total = n * (n-1) / 2
 */
public class CountBadPairs {
    public static long countBadPairs(int[] nums) {
        int n = nums.length;
        long validPairs = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int val = map.getOrDefault(i - nums[i], 0);
            validPairs += val;
            map.put(i - nums[i], map.getOrDefault(i - nums[i], 0)+ 1);
        }

        return 1L*n*(n-1)/2-validPairs;
    }
}

class TestCountBadPairs {
    @Test
    public void testCountBadPairs() {
        int[] nums = new int[]{4,1,3,3};
        int expected = 5;
        long output = CountBadPairs.countBadPairs(nums);
        assertEquals(output,expected);
    }

    @Test
    public void testCountBadPairs1() {
        int[] nums = new int[]{1,2,3,4,5};
        int expected = 0;
        long output = CountBadPairs.countBadPairs(nums);
        assertEquals(output,expected);
    }
}
