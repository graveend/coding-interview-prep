package arrays.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/continuous-subarray-sum/description/
 */
public class ContinuousSubArraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> remainderToIndex = new HashMap<>();
        int sum = 0;
        remainderToIndex.put(0,0);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if( !remainderToIndex.containsKey(sum % k) ) {
                remainderToIndex.put(sum % k, i+1);

            } else if(remainderToIndex.get(sum %k) < i) {
                return true;
            }
        }
        return false;
    }
}

class TestContinuousSubArraySum {

    @Test
    public void testSubArraySum() {
        int[] nums = new int[]{23,2,4,6,6};
        int k = 7;
        boolean expected = true;
        boolean output = ContinuousSubArraySum.checkSubarraySum(nums,k);
        assertEquals(output, expected);
    }

    @Test
    public void testSubArraySum1() {
        int[] nums = new int[]{23,2,4,6,7};
        int k = 6;
        boolean expected = true;
        boolean output = ContinuousSubArraySum.checkSubarraySum(nums,k);
        assertEquals(output, expected);
    }

    @Test
    public void testSubArraySum2() {
        int[] nums = new int[]{23,2,6,4,7};
        int k = 13;
        boolean expected = false;
        boolean output = ContinuousSubArraySum.checkSubarraySum(nums,k);
        assertEquals(output, expected);
    }
}
