package arrays.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int i = 1, j = 1;
        while(j < nums.length) {
            if( nums[j-1] != nums[j]) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
}

class TestRemoveDuplicates {
    @Test
    public void testDupliates() {
        int[] nums =new int[]{1,1,2};
        int expected_k = 2;
        int[] expected = new int[]{1,2};
        int k = RemoveDuplicates.removeDuplicates(nums);

        assertEquals(k,expected_k);
        for(int i = 0; i < expected.length; i++) {
            assertEquals(nums[i],expected[i]);
        }
    }
    @Test
    public void testDupliates1() {
        int[] nums =new int[]{0,0,1,1,1,2,2,3,3,4};
        int expected_k = 5;
        int[] expected = new int[]{0,1,2,3,4};
        int k = RemoveDuplicates.removeDuplicates(nums);

        assertEquals(k,expected_k);
        for(int i = 0; i < expected.length; i++) {
            assertEquals(nums[i],expected[i]);
        }
    }

}
