package arrays.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class BestTimeToBuyOrSellStockII {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }
}

class TestBestTimeToBuyOrSellStockII {
    @Test
    public void testMaxProfit() {
        int[] prices = new int[]{7,1,5,3,6,4};
        int expected = 7;
        int output = BestTimeToBuyOrSellStockII.maxProfit(prices);
        assertEquals(expected, output);
    }

    @Test
    public void testMaxProfit1() {
        int[] prices = new int[]{1,2,3,4,5};
        int expected = 4;
        int output = BestTimeToBuyOrSellStockII.maxProfit(prices);
        assertEquals(expected, output);
    }

    @Test
    public void testMaxProfit2() {
        int[] prices = new int[]{7,6,4,3,1};
        int expected = 0;
        int output = BestTimeToBuyOrSellStockII.maxProfit(prices);
        assertEquals(expected, output);
    }
}
