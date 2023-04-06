package matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfClosedIslands {
    public static int closedIsland(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        int res = 0;
        // iterate through each item and see if it is a land
        for(int i = 1; i < row - 1; i++) {
            for(int j = 1; j < col - 1; j++) {
                if(grid[i][j] == 0) {
                    if(isClosedIsland(grid, i, j)) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    private static boolean isClosedIsland(int[][] grid, int i, int j) {
        // If it's the land is surrounded with water or if the land is already visited then return true
        if(grid[i][j] == 1 || grid[i][j] == -1) {
            return true;
        }

        // Boundary check
        if(isOutOfGrid(grid, i, j)) return false;

        grid[i][j] = -1;

        // traverse all 4 directions to see if it is an island
        boolean left = isClosedIsland(grid, i , j-1);
        boolean right = isClosedIsland(grid, i , j+1);
        boolean up = isClosedIsland(grid, i -1 , j);
        boolean down = isClosedIsland(grid, i+1 , j);

        return left && right && up && down;


    }

    private static boolean isOutOfGrid(int[][] grid, int i, int j) {
        int row = grid.length, col = grid[0].length;
        return i == 0 || j == 0 || i == row - 1|| j == col - 1;
    }
}

class TestNumberOfClosedIslands {

    @Test
    public void testIsland() {
        int[][] grid = new int[][]{{1,1,1,1,1,1,1,0},
                                    {1,0,0,0,0,1,1,0},
                                    {1,0,1,0,1,1,1,0},
                                    {1,0,0,0,0,1,0,1},
                                    {1,1,1,1,1,1,1,0}};
        int expected = 2;
        int output = NumberOfClosedIslands.closedIsland(grid);
        assertEquals(expected, output);
    }

    @Test
    public void testIsland1() {
        int[][] grid = new int[][]{{0,0,1,0,0},
                                    {0,1,0,1,0},
                                    {0,1,1,1,0}};
        int expected = 1;
        int output = NumberOfClosedIslands.closedIsland(grid);
        assertEquals(expected, output);
    }
}
