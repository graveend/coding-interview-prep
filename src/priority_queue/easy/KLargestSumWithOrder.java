package priority_queue.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/description/
 */
public class KLargestSumWithOrder {
    public static int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            pq.offer(new int[]{num, i});
            if(pq.size() > k) {
                pq.poll();
            }
        }

        // Add the indexes to maintain order
        Set<Integer> indexes = new HashSet<>();
        while(!pq.isEmpty()) {
            indexes.add(pq.poll()[1]);
        }
        int[] res = new int[k];
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(indexes.contains(i)) {
                res[j++] = nums[i];
            }
        }

        return res;
    }
}

class TestKLargestSumWithOrder {
    @Test
    public void testMaxSubsequence() {
        int[] nums = new int[]{2,1,3,3};
        int k = 2;
        int[] actual = KLargestSumWithOrder.maxSubsequence(nums,k);
        int[] expected = new int[]{3,3};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void testMaxSubsequence1() {
        int[] nums = new int[]{50, -75};
        int k = 2;
        int[] actual = KLargestSumWithOrder.maxSubsequence(nums,k);
        int[] expected = new int[]{50, -75};
        assertArrayEquals(actual, expected);
    }
}
