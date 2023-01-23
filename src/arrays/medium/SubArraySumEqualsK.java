package arrays.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 *
 * Solution: https://leetcode.com/problems/subarray-sum-equals-k/solutions/127728/subarray-sum-equals-k/?orderBy=most_votes
 */
public class SubArraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> sumToOccurance = new HashMap<>();
        int count = 0, sum = 0;
        sumToOccurance.put(0, 1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if( sumToOccurance.containsKey(sum - k)) {
                count += sumToOccurance.get(sum - k);
            }
            sumToOccurance.put(sum, sumToOccurance.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

class TestSubArraySumEqualsK {

    @Test
    public void testSubArraySum() {
        int[] nums = new int[]{1,2,3};
        int k = 3;
        int expected = 2;
        int output = SubArraySumEqualsK.subarraySum(nums,k);
        assertEquals(expected,output);
    }

    @Test
    public void testSubArraySum1() {
        int[] nums = new int[]{1,2,3};
        int k = 3;
        int expected = 2;
        int output = SubArraySumEqualsK.subarraySum(nums,k);
        assertEquals(expected,output);
    }

    @Test
    public void testSubArraySum2() {
        int[] nums = new int[]{1,1,1};
        int k = 2;
        int expected = 2;
        int output = SubArraySumEqualsK.subarraySum(nums,k);
        assertEquals(expected,output);
    }
}
