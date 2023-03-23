package dp.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        if(amount<1) return 0;
        return helper(coins, amount, new int[amount]);

    }

    private static int helper(int[] coins, int rem, int[] count) {
        // rem: remaining coins after the last step; count[rem]:
        // minimum number of coins to sum up to rem
        if(rem<0) return -1; // not valid
        if(rem==0) return 0; // completed

        if(count[rem-1] != 0) return count[rem-1]; // already computed, so reuse

        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            int res = helper(coins, rem-coin, count);
            if(res>=0 && res < min)
                min = 1+res;
        }
        count[rem-1] = (min==Integer.MAX_VALUE) ? -1 : min;
        return count[rem-1];
    }
}

class TestCoinChange {

    @Test
    public void testCoins() {
        int[] coins = new int[]{1,2,5};
        int amount = 11;
        int expected = 3;
        int output = CoinChange.coinChange(coins, amount);
        assertEquals(expected, output);
    }

    @Test
    public void testCoins1() {
        int[] coins = new int[]{2};
        int amount = 3;
        int expected = -1;
        int output = CoinChange.coinChange(coins, amount);
        assertEquals(expected, output);
    }
}
