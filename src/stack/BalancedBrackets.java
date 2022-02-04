package stack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BalancedBrackets {
    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    private static String closingBrackets = ")}]";
    private static String openingBrackets = "({[";

    public static String isBalanced(String s) {
        // Write your code here
        Stack<String> stack = new Stack<>();
        char[] chArray = s.toCharArray();
        for (char c : chArray) {
            String value = String.valueOf(c);
            if (!stack.isEmpty()) {
                if (closingBrackets.contains(value)) {
                    if (openingBrackets.indexOf(stack.peek()) != closingBrackets.indexOf(value)) return "NO";
                    stack.pop();
                } else {
                    stack.push(value);
                }
            } else {
                stack.push(value);
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static List<String> callMethod(List<String> inputs) {
        List<String> output = new ArrayList<String>();
        for (String input : inputs) {
            output.add(isBalanced(input));
        }
        return output;
    }
}

class BalancedBracketsTest {
    @Test
    public void TestBalancedBrackets() {
        List<String> output = BalancedBrackets.callMethod(Arrays.asList("{[()]}"));
        List<String> expected = Arrays.asList("YES");
        assertEquals(expected, output);
    }

    @Test
    public void TestUnbalancedBrackets() {
        List<String> output = BalancedBrackets.callMethod(Arrays.asList("{[()"));
        List<String> expected = Arrays.asList("NO");
        assertEquals(expected, output);
    }
}

