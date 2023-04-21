package dp.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/decode-ways/description/
 *
 */
public class DecodeWays {
    public static int numDecoding(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        for(int i = n-1; i >= 0; i--) {
            if(s.charAt(i) == '0') continue;
            dp[i] = dp[i+1];
            if( i < n-1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7') ) ) {
                dp[i] += dp[i+2];
            }
        }
        return dp[0];
    }

    public static int numDecoding1(String s) {
        int n = s.length();
        int next = 1, next_next = 0;
        for(int i = n-1; i >= 0; i--) {
            int curr = s.charAt(i) == '0' ? 0 : next;
            if( i < n-1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7') ) ) {
                curr += next_next;
            }
            next_next = next;
            next = curr;
        }
        return next;
    }
}

class TestDecodeWays {
    @Test
    public void testDecodeWays() {
        String s = "12";
        int expected = 2;
        int output = DecodeWays.numDecoding(s);
        assertEquals(expected, output);
    }

    @Test
    public void testDecodeWays1() {
        String s = "226";
        int expected = 3;
        int output = DecodeWays.numDecoding(s);
        assertEquals(expected, output);
    }

    @Test
    public void testDecodeWays2() {
        String s = "06";
        int expected = 0;
        int output = DecodeWays.numDecoding1(s);
        assertEquals(expected, output);
    }
}
