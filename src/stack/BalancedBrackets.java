package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BalancedBrackets {
    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    /**
     * Solution
     */
    public static String isBalanced(String s) {
        Stack<String> stack = new Stack<>();
        String[] substrings = s.split("");

        for (String ch : substrings) {
            if (!stack.isEmpty()) {
                String closingBrackets = ")}]";
                if (closingBrackets.contains(ch)) {
                    String openingBrackets = "({[";
                    if (openingBrackets.indexOf(stack.peek()) != closingBrackets.indexOf(ch)) return "NO";
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static List<String> callMethod(List<String> inputs) {
        List<String> output = new ArrayList<>();
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

