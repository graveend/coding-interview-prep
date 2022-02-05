package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeLevelOrderTraversal {

    /*
     *                  5
     *           3           6
     *        1     4
     *
     *        output: 5, 3, 6, 1, 4
     */

    /**
     * Solution
     */
    public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }

    public static Node constructTree(int[] data) {
        Node root = null;
        for (int datum : data) {
            root = insert(root, datum);
        }
        return root;
    }
}

class TestBinaryTreeLevelOrderTraversal {
    @Test
    public void TestBinaryTreeHeight() throws Exception {
        Node root = BinaryTreeLevelOrderTraversal.constructTree(new int[]{1, 2, 5, 3, 6, 4});
        String expected = "1 2 5 3 6 4 ";
        String returned = tapSystemOut(() -> BinaryTreeLevelOrderTraversal.levelOrder(root));
        assertEquals(expected, returned);
    }
}

