package linkedlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        ListNode current = head, next = head;
        ListNode prev = null;
        while( current != null ) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}

class TestReverseLinkedList {
    @Test
    @DisplayName("Test positive scenario")
    public void testReverseLinkedList() {
        ListNode input = ListNode.convertArrayToList(new Integer[]{1,2,3,4,5});
        ListNode expected = ListNode.convertArrayToList(new Integer[]{5,4,3,2,1});
        input = ReverseLinkedList.reverseList(input);
        assertTrue(ListNode.equals(input, expected));
    }

    @Test
    @DisplayName("Test empty scenario")
    public void testSingleReverseLinkedList() {
        ListNode input = ListNode.convertArrayToList(new Integer[]{1});
        ListNode expected = ListNode.convertArrayToList(new Integer[]{1});
        input = ReverseLinkedList.reverseList(input);
        assertTrue(ListNode.equals(input, expected));
    }

    @Test
    @DisplayName("Test empty scenario")
    public void testEmptyReverseLinkedList() {
        ListNode input = ListNode.convertArrayToList(new Integer[]{});
        ListNode expected = ListNode.convertArrayToList(new Integer[]{});
        input = ReverseLinkedList.reverseList(input);
        assertTrue(ListNode.equals(input, expected));
    }
}
