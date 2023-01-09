package linkedlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *  https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 *  Point to Note here:
 *  1. Reverse what is needed
 *  2. head might change if left = 1
 */
public class ReverseLinkedListByPosition {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode current = head;
        int position = 1;
        ListNode prev = head;

        // process till left-1
        while(position < left) {
            prev = current;
            current = current.next;
            position++;
        }

        // reverse left to right values
        ListNode tail = current;
        ListNode newList = null;
        while(position >= left && position <= right) {
            ListNode nextNode = current.next;
            current.next = newList;
            newList = current;
            current = nextNode;
            position++;
        }

        prev.next = newList;
        tail.next = current;

        // check to return the head If left is 1 then the head value will change.
        if( left > 1 ) {
            return head;
        } else {
            return newList;
        }
    }
}

class TestReverseLinkedListByPosition {
    @Test
    @DisplayName("Reverse linked list between 2 points")
    public void testReverseBetween() {
        Integer[] input = new Integer[]{1,2,3,4,5};
        int left = 2;
        int right = 4;
        ListNode inputHead = ListNode.convertArrayToList(input);
        Integer[] expected = new Integer[]{1,4,3,2,5};
        ListNode expectedHead = ListNode.convertArrayToList(expected);
        ListNode output = ReverseLinkedListByPosition.reverseBetween(inputHead, left, right);
        assertTrue(ListNode.equals(output,expectedHead));

    }

    @Test
    @DisplayName("Reverse linked list that contains single node")
    public void testReverseSingleNodeList() {
        Integer[] input = new Integer[]{5};
        int left = 1;
        int right = 1;
        ListNode inputHead = ListNode.convertArrayToList(input);
        Integer[] expected = new Integer[]{5};
        ListNode expectedHead = ListNode.convertArrayToList(expected);
        ListNode output = ReverseLinkedListByPosition.reverseBetween(inputHead, left, right);
        assertTrue(ListNode.equals(output,expectedHead));

    }

    @Test
    @DisplayName("Reverse linked list that modifies position of head after reversal")
    public void testReverseEntireLinkedList() {
        Integer[] input = new Integer[]{3,5};
        int left = 1;
        int right = 2;
        ListNode inputHead = ListNode.convertArrayToList(input);
        Integer[] expected = new Integer[]{5,3};
        ListNode expectedHead = ListNode.convertArrayToList(expected);
        ListNode output = ReverseLinkedListByPosition.reverseBetween(inputHead, left, right);
        assertTrue(ListNode.equals(output,expectedHead));

    }
}
