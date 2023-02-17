package arrays.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class KClosestPointsToTheOrigin {
    public static int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
        return Arrays.copyOfRange(points, 0, k);
    }

    public static int[][] kClosest1(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> -a[0] * a[0] - a[1] * a[1]));
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) { pq.poll(); } // poll out the farthest among the K + 1 points.
        }
        // int[][] ans = new int[K][2];
        // while (K-- > 0) { ans[K] = pq.poll(); }
        // return ans; // the above 3 lines can be replaced by the following line.
        return pq.toArray(new int[K][2]);
    }
}

class TestKClosestPointsToTheOrigin {

    @Test
    public void testKClosest() {
        int[][] points = new int[][]{{1,3},{2,-2}};
        int k = 1;
        int[][] expected = new int[][]{{2,-2}};
        int[][] output = KClosestPointsToTheOrigin.kClosest(points, k);
        assertArrayEquals(expected,output);
    }

    @Test
    public void testKClosest1() {
        int[][] points = new int[][]{{1,3},{2,-2}};
        int k = 1;
        int[][] expected = new int[][]{{2,-2}};
        int[][] output = KClosestPointsToTheOrigin.kClosest1(points, k);
        assertArrayEquals(expected,output);
    }


}
