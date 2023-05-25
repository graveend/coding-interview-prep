package priority_queue.easy;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/sort-even-and-odd-indices-independently/description/
 */
public class SortOddAndEvenIndices {
    public static int[] sortEvenOdd(int[] nums) {
        PriorityQueue<Integer> even = new PriorityQueue<>();
        PriorityQueue<Integer> odd = new PriorityQueue<>(Comparator.reverseOrder());
        int i = 0;
        for(int num : nums) {
            if(i % 2 == 0) {
                even.offer(num);
            } else {
                odd.offer(num);
            }
            i++;
        }
        int[] res = new int[nums.length];
        i=0;
        for(int num : nums) {
            if(i % 2 == 0) {
                res[i] = even.poll();
            } else {
                res[i] = odd.poll();
            }
            i++;
        }

        return res;

    }
}

class TestSortOddAndEvenIndices {
    @Test
    public void testSortEvenOdd() {
        int[] nums = new int[]{4,1,2,3};
        int[] expected = new int[]{2,3,4,1};
        int[] output = SortOddAndEvenIndices.sortEvenOdd(nums);
        assertArrayEquals(expected, output);
    }
}
