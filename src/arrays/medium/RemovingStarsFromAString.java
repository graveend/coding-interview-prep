package arrays.medium;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/removing-stars-from-a-string/
 */
public class RemovingStarsFromAString {
    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character ch: s.toCharArray()) {
            if(ch == '*' && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        char[] word = new char[stack.size()];
        int N = stack.size() - 1;
        while(!stack.isEmpty()) {
            word[N--] = stack.pop();
        }
        return new String(word);
    }
}

class TestRemovingStarsFromAString {
    @Test
    public void testString() {
        String s = "leet**cod*e";
        String expected = "lecoe";
        String output = RemovingStarsFromAString.removeStars(s);
        assertEquals(expected, output);
    }
}
