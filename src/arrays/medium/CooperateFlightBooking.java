package arrays.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 *
 * https://leetcode.com/problems/corporate-flight-bookings/description/
 *
 *
 *     HINT: Sweep line
 *
 *     Explanation
 *         Set the change of seats for each day.
 *         If booking = [i, j, k],
 *         it needs k more seat on ith day,
 *         and we don't need these seats on j+1th day.
 *         We accumulate these changes then we have the result that we want.
 *
 *
 *     Complexity
 *         Time O(booking + N) for one pass on bookings
 *         Space O(N) for the result
 *
 *     bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 *
 *             1, 2,  3,  4,  5
 *     res = [10, 45,-10,-20, 0]
 *             0,  1,  2,  3,  4
 *
 *     res[0] = 10, 55, 45, 25, 25
 *
 *
 *  */
public class CooperateFlightBooking {
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for(int[] booking : bookings) {
            res[booking[0] - 1] += booking[2];
            if(booking[1] < n) res[booking[1]] -= booking[2];
        }

        for(int i = 1; i < n; i++) {
            res[i] += res[i-1];
        }
        return res;
    }
}

class TestCooperateFlightBooking {

    @Test
    public void testBookings() {
        int[][] bookings = new int[][]{{1,2,10}, {2,3,20}, {2,5,25}};
        int n = 5;
        int[] expected = new int[]{10,55,45,25,25};
        int[] output = CooperateFlightBooking.corpFlightBookings(bookings,n);
        assertArrayEquals(expected,output);
    }

    @Test
    public void testBookings1() {
        int[][] bookings = new int[][]{{1,2,10}, {2,2,15}};
        int n = 2;
        int[] expected = new int[]{10,25};
        int[] output = CooperateFlightBooking.corpFlightBookings(bookings,n);
        assertArrayEquals(expected,output);
    }
}
