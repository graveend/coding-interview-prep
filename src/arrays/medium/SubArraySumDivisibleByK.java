package arrays.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
 */
public class SubArraySumDivisibleByK {
    public static int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer,Integer> remainderToCount = new HashMap<>();
        remainderToCount.put(0,1);
        for(int j = 0; j < nums.length; j++) {
            sum += nums[j];
            int rem = sum % k;
            // In Java if negative number comes, for eg: -3%5 gives -3 instead of 2.
            // So make it correct we need to add the divisor to it. ie.. -3+5 gives 2.
            if( rem < 0) rem += k;
            count += remainderToCount.getOrDefault(rem,0);
            remainderToCount.put(rem, remainderToCount.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}

class TestSubArraySumDivisibleByK {

    @Test
    public void testSubArrayDivByK() {
        int[] nums = new int[]{4,5,0,-2,-3,1};
        int k = 5;
        int expected = 7;
        int output = SubArraySumDivisibleByK.subarraysDivByK(nums,k);
        assertEquals(expected, output);
    }

    @Test
    public void testSubArrayDivByK1() {
        int[] nums = new int[]{5};
        int k = 9;
        int expected = 0;
        int output = SubArraySumDivisibleByK.subarraysDivByK(nums,k);
        assertEquals(expected, output);
    }
}
