package linkedlist;

/**
 * Doubly linked list Node
 */
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node prev) {
        this.val = val;
        this.prev = prev;
    }

    public Node(int val, Node prev, Node next, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }

    public static Node convertArrayToList(Integer[] input){
        Node head = null;
        Node current = null;
        for(int value : input) {
            if(head==null) {
                head = new Node(input[0]);
                current = head;
            }else {
                current.next = new Node(value);
                current.next.prev = current;
                current = current.next;
            }
        }
        current.next = null;
        return head;
    }

    public static boolean equals(Node l1, Node l2) {
        while(l1 != null && l2 != null) {
            if( l1.val != l2.val ) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 != null || l2 != null) return false;
        return true;
    }
}
