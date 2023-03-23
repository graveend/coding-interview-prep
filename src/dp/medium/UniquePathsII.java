package dp.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/unique-paths-ii/description/
 */
public class UniquePathsII {
    public static int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) return 0;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(grid, 0, 0, dp);
    }

    private static int solve(int[][] grid, int row, int col, int[][] dp) {
        if(row >= grid.length - 1 && col >= grid[0].length - 1) return 1;
        if(row >= grid.length || col >= grid[0].length || grid[row][col] == 1) return 0;
        if(dp[row][col] != -1) return dp[row][col];

        dp[row][col] = solve(grid, row+1, col, dp) + solve(grid, row, col+1, dp);

        return dp[row][col];
    }
}

class TestUniquePathsII {
    @Test
    public void testUniquePaths() {
        int[][] grid = new int[][]{{0,0,0}, {0,1,0}, {0,0,0}};
        int expected = 2;
        int output = UniquePathsII.uniquePathsWithObstacles(grid);
        assertEquals(expected, output);
    }

    @Test
    public void testUniquePaths1() {
        int[][] grid = new int[][]{{0,1}, {0,0}};
        int expected = 1;
        int output = UniquePathsII.uniquePathsWithObstacles(grid);
        assertEquals(expected, output);
    }
}
