package dp.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/unique-paths/description/
 */
public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        grid[0][0] = 1;
        for(int r = 0; r < m; r++) {
            for(int c = 0;c < n; c++) {
                if( r > 0) {
                    grid[r][c] += grid[r-1][c];
                }
                if( c > 0) {
                    grid[r][c] += grid[r][c - 1];
                }
            }
        }
        return grid[m-1][n-1];
    }
}

class TestUniquePaths {
    @Test
    public void testUniquePaths() {
        int m = 3;
        int n = 7;
        int expected = 28;
        int output = UniquePaths.uniquePaths(m,n);
        assertEquals(expected,output);
    }

    @Test
    public void testUniquePaths1() {
        int m = 3;
        int n = 2;
        int expected = 3;
        int output = UniquePaths.uniquePaths(m,n);
        assertEquals(expected,output);
    }
}
