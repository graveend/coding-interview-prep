package arrays.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class BestTimeToSellStock {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minStock = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < minStock) {
                minStock = prices[i];
            } else if(prices[i] - minStock > maxProfit) {
                maxProfit = prices[i] - minStock;
            }
        }
        return maxProfit;
    }
}

class TestBestTimeToSellStock {
    @Test
    public void testMaxProfit() {
        int[] prices = new int[]{7,1,5,3,6,4};
        int expected = 5;
        int output = BestTimeToSellStock.maxProfit(prices);
        assertEquals(expected, output);
    }

    @Test
    public void testMaxProfitNull() {
        int[] prices = new int[]{7,6,4,3,1};
        int expected = 0;
        int output = BestTimeToSellStock.maxProfit(prices);
        assertEquals(expected, output);
    }
}
