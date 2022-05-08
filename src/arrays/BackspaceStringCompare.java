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

    // Best approach - 2 pointers - refer
    public static boolean backspaceCompareOptimalSolution(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int sCount = 0;
        int tCount = 0;
        while(i >= 0 || j >= 0) {

            // skip s
            while( i >= 0) {
                if( s.charAt(i) == '#') {
                    sCount++;
                    i--;
                } else if (sCount > 0) {
                    sCount--;
                    i--;
                } else {
                    break;
                }
            }

            // skip t
            while( j >= 0) {
                if( t.charAt(j) == '#') {
                    tCount++;
                    j--;
                } else if (tCount > 0) {
                    tCount --;
                    j--;
                } else {
                    break;
                }
            }

            // after skipping all the unnecessary character check if the characters are matching, if not return false
            if( i >= 0 && j>=0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }

            // check if any one of the string is having extra characters compared to other string
            if( i >= 0 != j >= 0) return false;

            i--;
            j--;

        }
        return true;

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
