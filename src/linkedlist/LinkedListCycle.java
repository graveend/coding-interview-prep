package linkedlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/linked-list-cycle/description/
 */
public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}

class TestLinkedListCycle {
    @Test
    @DisplayName("Test linked list that has a cycle")
    public void testLinkedListCycle() {
        Integer[] inputData = new Integer[]{1,2,3,4,5};
        ListNode input = ListNode.convertArrayToList(inputData);
        ListNode currentInput = input;
        while(currentInput.next != null) {
            currentInput = currentInput.next;
        }
        currentInput.next = input.next;
        assertTrue(LinkedListCycle.hasCycle(input));
    }

    @Test
    @DisplayName("Test linked list that doesn't have a cycle")
    public void testLinkedListWithoutCycle() {
        Integer[] inputData = new Integer[]{1,2,3,4,5};
        ListNode input = ListNode.convertArrayToList(inputData);
        assertFalse(LinkedListCycle.hasCycle(input));
    }
}
