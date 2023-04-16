package stack.medium;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/validate-stack-sequences/description/
 */
public class ValidateStackSequence {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i = 0; i < pushed.length; i++) {
            if(pushed[i] == popped[j]) {
                j++;
                continue;
            }
            while(!stack.isEmpty() && popped[j] == stack.peek()) {
                stack.pop();
                j++;

            }
            stack.push(pushed[i]);
        }
        while(j < popped.length && !stack.isEmpty()) {
            if(popped[j] == stack.peek()) {
                stack.pop();
                j++;
            }else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}

class TestValidateStackSequence {
    @Test
    public void testSequence() {
        int[] push = new int[]{1,2,3,0};
        int[] pop = new int[]{2,1,3,0};
        boolean expected = true;
        boolean output = ValidateStackSequence.validateStackSequences(push, pop);
        assertEquals(expected, output);
    }

    @Test
    public void testSequence1() {
        int[] push = new int[]{2,3,0,1};
        int[] pop = new int[]{0,3,2,1};
        boolean expected = true;
        boolean output = ValidateStackSequence.validateStackSequences(push, pop);
        assertEquals(expected, output);
    }
}
