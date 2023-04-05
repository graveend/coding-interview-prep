package dp.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/ones-and-zeroes/description/
 */
public class OnesAndZeroes {
    static int[][][] dp;
    public static int findMaxForm(String[] strs, int m, int n) {
        dp = new int[strs.length][m + 1][n + 1];
        int[][] freqMap = new int[strs.length][2];

        for(int i = 0; i < strs.length; i++) {
            freqMap[i] = getOnesAndZeroCount(strs[i]);
        }

        return helper(strs, m, n, 0, freqMap);
    }

    public static int helper(String[] strs, int m, int n, int idx, int[][] freqMap) {
        if(idx >= strs.length || (m+n) <= 0) {
            return 0;
        }

        if(dp[idx][m][n] > 0) {
            return dp[idx][m][n];
        }

        int zeroes = freqMap[idx][0];
        int ones = freqMap[idx][1];

        int includeCurrStr = 0;
        if(m >= zeroes && n >= ones) {
            includeCurrStr = 1 + helper(strs, m - zeroes, n - ones, idx + 1, freqMap);
        }
        int excludeCurrStr = helper(strs, m, n, idx + 1, freqMap);

        dp[idx][m][n] =  Math.max(includeCurrStr, excludeCurrStr);
        return dp[idx][m][n];
    }


    private static int[] getOnesAndZeroCount(String str) {
        int[] freq = new int[2];
        for(char c : str.toCharArray()) {
            if(c == '0') {
                freq[0]++;
            } else {
                freq[1]++;
            }
        }
        return freq;
    }
}

class TestOnesAndZeroes {

    @Test
    public void testZeroesAndOnes() {
        String[] str = new String[]{"10","0001","111001","1","0"};
        int m = 5, n = 3;
        int expected = 4;
        int output = OnesAndZeroes.findMaxForm(str, m, n);
        assertEquals(expected, output);
    }

    @Test
    public void testZeroesAndOnes1() {
        String[] str = new String[]{"10","0","1"};
        int m = 1, n = 1;
        int expected = 2;
        int output = OnesAndZeroes.findMaxForm(str, m, n);
        assertEquals(expected, output);
    }
}
