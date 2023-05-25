package priority_queue.easy;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/last-stone-weight/
 *
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int stone : stones) {
            pq.offer(stone);
        }

        while(pq.size() > 1) {
            pq.offer(pq.poll() - pq.poll());
        }
        return pq.poll();
    }
}

class TestLastStoneWeight {
    @Test
    public void testLastStoneWeight() {
        int[] stones = new int[]{2,7,4,1,8,1};
        int expected = 1;
        int output = LastStoneWeight.lastStoneWeight(stones);
        assertEquals(expected, output);
    }
}
