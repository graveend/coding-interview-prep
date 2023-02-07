package arrays.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/longest-nice-substring/description/
 */
public class LongestNiceSubstring {
    public static String longestNiceSubstring(String s) {
        if(s.length() < 2) return "";

        // create a set with all the characters found in the string
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char c : arr) {
            set.add(c);
        }
        for(int i = 0; i < s.length(); i++) {
            char ch = arr[i];
            // continue until a character without its counterpart is found
            if(set.contains(Character.toUpperCase(ch)) && set.contains(Character.toLowerCase(ch))) continue;

            // recursively call the left and right substring ignoring the wrong character
            String left = longestNiceSubstring(s.substring(0,i));
            String right = longestNiceSubstring(s.substring(i+1));
            return left.length() >= right.length() ? left : right;

        }
        return s;
    }
}
class TestLongestNiceSubstring {

    @Test
    public void testSubstring1() {
        String s = "YazaAay";
        String expected = "aAa";
        String output = LongestNiceSubstring.longestNiceSubstring(s);
        assertEquals(expected, output);
    }

    @Test
    public void testSubstring2() {
        String s = "Bb";
        String expected = "Bb";
        String output = LongestNiceSubstring.longestNiceSubstring(s);
        assertEquals(expected, output);
    }

    @Test
    public void testSubstring3() {
        String s = "c";
        String expected = "";
        String output = LongestNiceSubstring.longestNiceSubstring(s);
        assertEquals(expected, output);
    }

}

