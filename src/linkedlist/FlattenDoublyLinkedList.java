package linkedlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/description/
 */
public class FlattenDoublyLinkedList {
    public static Node flatten(Node head) {
        Node current = head;
        while(current != null) {
            if(current.child != null) {
                Node temp = current; // 3
                current = current.child;
                while(current.next != null) {
                    current = current.next;
                }
                // link right side list
                current.next = temp.next;
                if(temp.next != null) {
                    temp.next.prev = current;
                }

                // link left side list
                temp.next = temp.child;
                temp.child.prev = temp;
                temp.child = null;
                current = temp.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}

class TestFlattenDoublyLinkedList {
    @Test
    @DisplayName("Test positive scenario")
    public void testFlattenList() {
        Node input = mockData();
        Node output = FlattenDoublyLinkedList.flatten(input);

        Integer[] expectedData = new Integer[]{1,2,3,4,5,6,7,8};
        Node expected = Node.convertArrayToList(expectedData);
        assertTrue(Node.equals(output,expected));
    }


    private Node mockData() {
        Node head = new Node(1);
        Node current = head;
        Node next = new Node(2, current);
        current.next = next;
        current = next;

        next = new Node(3, current);
        current.next = next;
        current = next;

        // --------create child list-----------
        Node child = new Node(4);
        Node currentChild = child;
        Node nextChild = new Node(5, currentChild);
        currentChild.next = nextChild;
        currentChild = nextChild;

        nextChild = new Node(6, currentChild);
        currentChild.next = nextChild;
        currentChild = nextChild;

        nextChild = new Node(7, currentChild);
        currentChild.next = nextChild;
        currentChild = nextChild;

        nextChild = null;
        currentChild.next = nextChild;
        // -----------------------------

        // -----------Link Child Node------------
        current.child = child;
        // -------------------------------

        next = new Node(8, current);
        current.next = next;
        current = next;

        next = null;
        current.next = next;

        return head;
    }
}
