package arrays.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://www.youtube.com/watch?v=bOk35XmHPKs
 *
 * Divide and conquer
 *
 *              {3,1,2,5,4}
 *      {3,1,2}             {5,4}
 *   {3,1}      {2}      {5}     {4}
 * {3} {1}      {2}      {5}     {4}
 *    {1,3}     {2}      {5}     {4}
 *          {1,2,3}         {4,5}
 *              {1,2,3,4,5}
 */
public class MergeSort {
    public static void mergeSort(int[] nums) {
        int N = nums.length;
        if(N < 2) return;
        int midIdx = N/2;

        int[] left = new int[midIdx];
        int[] right = new int[N - midIdx];

        // Divide input array to left and right arrays
        for(int i = 0; i < midIdx; i++) {
            left[i] = nums[i];
        }

        for(int i = midIdx; i < N; i++) {
            right[i - midIdx] = nums[i];
        }

        mergeSort(left);
        mergeSort(right);

        // Merge
        merge(nums, left, right);
    }

    public static void merge(int[] nums, int[] left, int[] right) {
        int N = nums.length, l = 0, r = 0, k = 0;

        while (l < left.length && r < right.length) {
            if(left[l] <= right[r]) {
                nums[k++] = left[l++];
            } else {
                nums[k++] = right[r++];
            }
        }

        while (l < left.length) {
            nums[k++] = left[l++];
        }

        while (r < right.length) {
            nums[k++] = right[r++];
        }

    }
}

class TestMergeSort {

    @Test
    public void testMergeSort() {
        int[] nums = new int[]{3,1,2,5,4};
        int[] expected = new int[]{1,2,3,4,5};
        MergeSort.mergeSort(nums);
        assertArrayEquals(nums, expected);
    }
}
