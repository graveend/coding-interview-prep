package arrays.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/majority-element/description/
 */
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int number = -1;
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                Integer val = map.get(nums[i]);
                map.put(nums[i], val+1);
            } else {
                map.put(nums[i], 1);
            }

            if(map.get(nums[i]) > max) {
                number = nums[i];
                max = map.get(nums[i]);
            }
        }
        return number;
    }

    public static int majorityElementUsingBoyerMoore(int[] nums) {
        int count = 0;
        int majorityElem = nums[0];
        for(int num: nums) {
            if(majorityElem != num) {
                count--;
            } else {
                count++;
            }
            if(count == 0) {
                majorityElem = num;
                count++;
            }
        }
        return majorityElem;
    }
}

class TestMajorityElement {
    @Test
    public void majorityElement() {
        int[] nums = new int[]{3,2,3};
        int expected = 3;
        int output = MajorityElement.majorityElement(nums);
        assertEquals(expected,output);
    }

    @Test
    public void majorityElement2() {
        int[] nums = new int[]{3,2,3};
        int expected = 3;
        int output = MajorityElement.majorityElementUsingBoyerMoore(nums);
        assertEquals(expected,output);
    }

    @Test
    public void majorityElement1() {
        int[] nums = new int[]{6,5,5};
        int expected = 5;
        int output = MajorityElement.majorityElement(nums);
        assertEquals(expected,output);
    }
}
