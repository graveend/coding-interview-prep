package arrays.hard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestTimeToBuyOrSellStockIII {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minStock = Integer.MAX_VALUE;
        List<Integer> profits = new ArrayList<>();
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < minStock) {
                minStock = prices[i];
            } else {
                profits.add(prices[i] - minStock);
                minStock = Integer.MAX_VALUE;
            }
        }

        Collections.sort(profits);
        int len = profits.size();
        if(len > 1) {
            return profits.get(len - 1) + profits.get(len - 2);
        } else if( len == 1) {
            return profits.get(len - 1);
        } else {
            return 0;
        }

    }
}

class TestBestTimeToBuyOrSellStockIII {

    @Test
    public void testMaxProfit() {
        int[] input = new int[]{3,3,5,0,0,3,1,4};
        int expected = 6;
        int output = BestTimeToBuyOrSellStockIII.maxProfit(input);
        assertEquals(expected, output);
    }
}
