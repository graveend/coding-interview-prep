package arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/backspace-string-compare/
 */
public class BackspaceStringCompare {
    public static boolean backspaceCompare(String s, String t) {
        String s1 = getFinalString(s);
        String t1 = getFinalString(t);
        System.out.println(s1+", "+t1);
        return s1.equals(t1);
    }

    private static String getFinalString(String expression) {
        char[] ch = expression.toCharArray();
        StringBuilder sb = new StringBuilder();
        int hashCounter = 0;
        for(int i = ch.length - 1; i  >= 0 ; i--) {
            if(ch[i] == '#') {
                hashCounter++;
                continue;
            }
            if(hashCounter > 0) {
                hashCounter--;
                continue;
            }
            sb.append(ch[i]);

        }
        return sb.toString();
    }
}

class TestBackspaceStringCompare {

    @Test
    public void testBackspaceCompare() {
        boolean actual = BackspaceStringCompare.backspaceCompare("ab#c", "ad#c");
        assertTrue(actual);
    }

    @Test
    public void testBackspaceCompareReturnFalse() {
        boolean actual = BackspaceStringCompare.backspaceCompare("a#c", "b");
        assertFalse(actual);
    }

}
