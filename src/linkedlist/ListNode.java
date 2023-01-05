package linkedlist;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode convertArrayToList(Integer[] input){
        ListNode head = null;
        ListNode current = null;
        for(int value : input) {
            if(head==null) {
                head = new ListNode(input[0]);
                current = head;
            }else {
                current.next = new ListNode(value);
                current = current.next;
            }
        }
        return head;
    }

    public static boolean equals(ListNode l1, ListNode l2) {
        while(l1 != null && l2 != null) {
            if( l1.val != l2.val ) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 != null || l2 != null) return false;
        return true;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        System.out.println("LinkedList contains:");
        while(current != null) {
            System.out.print(current.val+" ");
            current = current.next;
        }
        System.out.print("/n -------------");
    }
}
