package arrays.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/merge-sorted-array/description/
 */
public class MergeSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int i = nums1.length - 1, j = nums2.length - 1; //[1,2,3,0,5,6] , [2,5,6]
        int k = m - 1;
        while (i >= 0) {
            if (m == 0) {
                nums1[i--] = nums2[j--];
            } else {
                if (j >= 0 && k >= 0 && nums1[k] > nums2[j]) {
                    nums1[i] = nums1[k];
                    k--;
                } else if (j >= 0) {
                    nums1[i] = nums2[j];
                    j--;
                }
                i--;
            }

        }
    }
}

class TestMergeSortedArrays {

    @Test
    public void testMerge1() {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int m = 3;
        int n = 3;
        int[] expected = new int[]{1,2,2,3,5,6};
        MergeSortedArrays.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }

    @Test
    public void testMerge2() {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{};
        int m = 1;
        int n = 0;
        int[] expected = new int[]{1};
        MergeSortedArrays.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }

    @Test
    public void testMerge3() {
        int[] nums1 = new int[]{2,0};
        int[] nums2 = new int[]{1};
        int m = 1;
        int n = 1;
        int[] expected = new int[]{1,2};
        MergeSortedArrays.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }
}
