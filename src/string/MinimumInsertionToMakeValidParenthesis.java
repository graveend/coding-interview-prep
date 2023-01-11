package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *  https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/description/
 *
 *  Solution: https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/solutions/780366/c-o-n-proper-explaination-without-stack/?orderBy=most_votes
 */
public class MinimumInsertionToMakeValidParenthesis {
    public static int minInsertions(String s) {
        int ans = 0, req = 0; // "))()"
        for(char c : s.toCharArray()) {
            if(c == '(') {
                // We require 2 ) to make it valid.
                req += 2;
                if(req%2 != 0) {
                    // req % 2 becomes non zero when there is odd number of ) encountered previously.
                    // req-- => remove the odd ) from req
                    // ans++ => add a ) to balance it
                    req--;
                    ans++;
                }
            } else {
                // Case: ')'
                if(req == 0) {
                    ans++;
                    req++;
                } else {
                    req--;
                }
            }
        }
        return ans + req;
    }
}

class TestMinimumInsertionToMakeValidParenthesis {

    @Test
    public void testMinInsertion1() {
        String input = "(";
        int expected = 2;
        int output = MinimumInsertionToMakeValidParenthesis.minInsertions(input);
        assertEquals(expected, output);
    }

    @Test
    public void testMinInsertion2() {
        String input = ")";
        int expected = 2;
        int output = MinimumInsertionToMakeValidParenthesis.minInsertions(input);
        assertEquals(expected, output);
    }

    @Test
    public void testMinInsertion3() {
        String input = "))(";
        int expected = 3;
        int output = MinimumInsertionToMakeValidParenthesis.minInsertions(input);
        assertEquals(expected, output);
    }

    @Test
    public void testMinInsertion4() {
        String input = "))(())))";
        int expected = 1;
        int output = MinimumInsertionToMakeValidParenthesis.minInsertions(input);
        assertEquals(expected, output);
    }

}
