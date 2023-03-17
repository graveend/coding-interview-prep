package arrays.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 */
public class FindFirstOccurrenceOfAString {
    public static int strStr(String haystack, String needle) {
        int i = 0, j = 0;
        int N = needle.length(), H = haystack.length();
        if(haystack.length() < needle.length()) return -1;

        while(j < haystack.length()) {
            while(i < N && j < H && haystack.charAt(j) == needle.charAt(i)) {
                i++;
                j++;
            }
            // reached end of Needle
            if(i == N) {
                return j - N;
            } else if(i > 0) {
                i = 0;
            } else {
                j++;
            }
        }
        return -1;
    }
}

class TestFindFirstOccurrenceOfAString {

    @Test
    public void testStringIndex() {
        String haystack = "mississippi";
        String needle = "issip";
        int expected = 4;
        int output = FindFirstOccurrenceOfAString.strStr(haystack, needle);
        assertEquals(expected, output);
    }
}
