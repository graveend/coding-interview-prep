package stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *  https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/
 */
public class MinimumBracketsToRemove {
    public static String minRemoveToMakeValid(String s) {
        char[] ch = s.toCharArray();
        Stack<Integer> st = new Stack();
        for(int i = 0; i < ch.length; i++) {
            if(ch[i] == ')') {
                if(st.isEmpty()) {
                    ch[i] = '*';
                } else {
                    st.pop();
                }
            } else if(ch[i] == '(') {
                st.push(i);
            }
        }
        while(!st.isEmpty()) {
            ch[st.pop()] = '*';
        }
        return String.valueOf(ch).replaceAll("\\*", "");
    }
}

class TestMinimumBracketsToRemove {
    @Test
    @DisplayName("Remove min brackets - Test positive scenario 1")
    public void testMinimumBracketsToRemove1() {
        String input = "abc(d)e(";
        List<String> list = Arrays.asList(new String[]{"abc(d)e"});
        String output = MinimumBracketsToRemove.minRemoveToMakeValid(input);
        assertTrue( list.contains(output) );
    }

    @Test
    @DisplayName("Remove min brackets - Test positive scenario 2")
    public void testMinimumBracketsToRemove2() {
        String input = "ab(c(d)e(";
        List<String> list = Arrays.asList(new String[]{"ab(cd)e", "abc(d)e"});
        String output = MinimumBracketsToRemove.minRemoveToMakeValid(input);
        assertTrue( list.contains(output) );
    }

    @Test
    @DisplayName("Remove min brackets - nothing to remove")
    public void testMinimumBracketsToRemove3() {
        String input = "ab(c(d)e)";
        List<String> list = Arrays.asList(new String[]{"ab(c(d)e)"});
        String output = MinimumBracketsToRemove.minRemoveToMakeValid(input);
        assertTrue( list.contains(output) );
    }
}
