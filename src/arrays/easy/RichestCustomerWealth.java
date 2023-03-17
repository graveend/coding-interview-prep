package arrays.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/richest-customer-wealth/description/
 */
public class RichestCustomerWealth {
    public static int maximumWealth(int[][] accounts) {
        int m = accounts.length;
        if( m < 0) {
            return -1;
        }
        int n = accounts[0].length;
        int max = 0;
        for(int i = 0; i < m; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                count += accounts[i][j];
            }
            max = Math.max(max, count);
        }
        return max;
    }
}

class TestRichestCustomerWealth {

    @Test
    public void testMax() {
       int[][] nums = new int[][]{{1,2,3},{3,2,1}};
       int expected = 6;
       int output = RichestCustomerWealth.maximumWealth(nums);
       assertEquals(expected, output);
    }

    @Test
    public void testMax1() {
        int[][] nums = new int[][]{{1,5},{7,3},{3,5}};
        int expected = 10;
        int output = RichestCustomerWealth.maximumWealth(nums);
        assertEquals(expected, output);
    }

}
