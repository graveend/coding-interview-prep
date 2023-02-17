package arrays.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://www.youtube.com/watch?v=h8eyY7dIiN4
 */
public class QuickSort {
    public static void sort(int[] nums) {
        int N = nums.length;
        quickSort(nums, 0, N-1);
    }

    private static void quickSort(int[] nums, int left, int right) {
        if(left >= right) return;

        int lp = left, rp = right, pivot = nums[right];
        while (lp < rp) {
            while(lp < rp && nums[lp] <= pivot) {
                lp++;
            }

            while(lp < rp && nums[rp] >= pivot) {
                rp--;
            }
            swap(nums, lp, rp);
        }
        swap(nums, lp, right);

        quickSort(nums, left, lp-1);
        quickSort(nums, lp + 1, right);
    }

    private static void swap(int[] nums, int lp, int rp) {
        int temp = nums[lp];
        nums[lp] = nums[rp];
        nums[rp] = temp;
    }
}

class TestQuickSort {
    @Test
    public void testSort() {
        int[] nums = new int[]{1,5,3,4,2};
        int[] expected = new int[]{1,2,3,4,5};
        QuickSort.sort(nums);
        assertArrayEquals(nums, expected);
    }

    @Test
    public void testSort1() {
        int[] nums = new int[]{5,4,3,2,1};
        int[] expected = new int[]{1,2,3,4,5};
        QuickSort.sort(nums);
        assertArrayEquals(nums, expected);
    }
}
