package dp.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/champagne-tower/description/
 */
public class ChampaignTower {
    public static double champagneTower(int poured, int row, int col) {
        double[][] quantity = new double[row+2][row+4];
        quantity[0][0] = poured;
        for(int i = 0; i <= row; i++) {
            for(int j = 0; j <= col; j++) {
                double rem = Math.max( quantity[i][j] - 1, 0);
                quantity[i+1][j] += rem/2.0;
                quantity[i+1][j+1] += rem/2.0;
            }
        }
        return Math.min(quantity[row][col], 1.0);
    }
}

class TestChampaignTower {

    @Test
    public void testTower() {
        int poured = 1;
        int row = 1;
        int col = 1;
        double expected = 0.0;
        double output = ChampaignTower.champagneTower(poured, row, col);
        assertEquals(expected, output);
    }

    @Test
    public void testTower1() {
        int poured = 2;
        int row = 1;
        int col = 1;
        double expected = 0.5;
        double output = ChampaignTower.champagneTower(poured, row, col);
        assertEquals(expected, output);
    }
}
