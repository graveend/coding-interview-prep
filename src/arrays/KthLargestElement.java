package arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/?orderBy=most_votes
 */
public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k, 0, nums.length - 1);
    }

    private static int quickSelect(int[] nums, int k, int left, int right) {
        int index = nums.length - k;
        while (left < right) {
            // quick sort to find pivot
            int pivot = partition(nums, left, right);
            if(index > pivot) {
                left = pivot + 1;
            } else if(index < pivot) {
                right = pivot - 1;
            } else {
                return nums[pivot];
            }
        }
        return nums[right];
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int lp = left, rp = right;
        while(lp < rp) {
            while(lp < rp && nums[lp] <= pivot) {
                lp++;
            }
            while(lp < rp && nums[rp] >= pivot) {
                rp--;
            }
            swap(nums, lp, rp);
        }
        swap(nums, lp, right);
        return lp;
    }

    private static void swap(int[] nums, int lp, int rp) {
        int temp = nums[lp];
        nums[lp] = nums[rp];
        nums[rp] = temp;
    }
}

class TestKthLargestElement {

    @Test
    public void testKthLargestElem() {
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        int expected = 5;
        int output = KthLargestElement.findKthLargest(nums, k);
        assertEquals(expected, output);
    }

    @Test
    public void testKthLargestElem1() {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        int k = 4;
        int expected = 4;
        int output = KthLargestElement.findKthLargest(nums, k);
        assertEquals(expected, output);
    }

}
