package arrays.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 */
public class FindFirstOccurrenceOfAString {
    public static int strStr(String haystack, String needle) {
        int haylength=haystack.length();
        int needlelength=needle.length();
        if(haylength<needlelength)
            return -1;
        for(int i=0;i<= haylength - needlelength;i++){
            int j=0;
            while(j<needle.length() && haystack.charAt(i+j)==needle.charAt(j))
                j++;
            if(j==needle.length()){
                return i;
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

    @Test
    public void testStringIndex1() {
        String haystack = "sadbutsad";
        String needle = "sad";
        int expected = 0;
        int output = FindFirstOccurrenceOfAString.strStr(haystack, needle);
        assertEquals(expected, output);
    }
}
