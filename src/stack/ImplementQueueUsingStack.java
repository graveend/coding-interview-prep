package stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/description/
 *
 * Solution: https://leetcode.com/problems/implement-queue-using-stacks/solutions/127533/implement-queue-using-stacks/?orderBy=most_votes
 */
public class ImplementQueueUsingStack {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public ImplementQueueUsingStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek() {
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

class TestImplementQueueUsingStack {

    @Test
    public void testQueue() {
        ImplementQueueUsingStack obj = new ImplementQueueUsingStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        int param_2 = obj.pop();
        boolean param_4 = obj.empty();
        assertEquals(param_2, 1);

        int param_3 = obj.peek();
        assertEquals(param_3, 2);

        assertEquals(param_4, false);
    }
}
