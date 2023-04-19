package dp.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 *
 *  Example: [1,2,3,0,2]
 *
 *     buy[i] = max(buy[i-1], rest[i-1]-prices[i]);
 *     sell[i] = max(sell[i-1], buy[i-1] + prices[i]);
 *     rest[i] = max(buy[i-1], sell[i-1], rest[i-1]);
 *
 *     buy[i] <= rest[i];
 *     => rest[i] = max(sell[i-1], rest[i-1]);
 *
 *     sell[i] >= rest[i]
 *     => rest[i] = sell[i-1]
 *
 *     Hence,
 *       buy[i] = (buy[i-1], sell[i-2]-prices[i]);
 *       sell[i] = (sell[i-1], buy[i-1] + prices[i]);
 */
public class BestTimeToBuyOrSellStockWithCooldown {
    public static int maxProfit(int[] prices) {
        int sell = 0, prevSell = 0, buy = Integer.MIN_VALUE, prevBuy = 0;
        for(int i = 0; i < prices.length; i++) {
            prevBuy = buy;
            buy = Math.max(prevBuy, prevSell-prices[i]);
            prevSell = sell;
            sell = Math.max(prevSell, prevBuy + prices[i]);
        }
        return sell;
    }
}

class TestBestTimeToBuyOrSellStockWithCooldown {

    @Test
    public void testStockProfit() {
        int[] prices = new int[]{1,2,3,0,2};
        int expected = 3;
        int output = BestTimeToBuyOrSellStockWithCooldown.maxProfit(prices);
        assertEquals(expected, output);
    }

    @Test
    public void testStockProfit1() {
        int[] prices = new int[]{1};
        int expected = 0;
        int output = BestTimeToBuyOrSellStockWithCooldown.maxProfit(prices);
        assertEquals(expected, output);
    }


}
