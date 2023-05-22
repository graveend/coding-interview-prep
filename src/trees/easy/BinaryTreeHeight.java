package trees.easy;

import models.Node;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
 */

public class BinaryTreeHeight {
    public static int height(Node root) {
        // Write your code here.
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
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
        int height = height(root);
        System.out.println(height);
    }

    public static Node constructTree(int[] data) {
        Node root = null;
        for (int i = 0; i < data.length; i++) {
            root = insert(root, data[i]);
        }
        return root;
    }
}

class TestBinaryTreeHeight {
    @Test
    public void TestBinaryTreeHeight() {
        Node root = BinaryTreeHeight.constructTree(new int[]{5});
        int expected = 0;
        int actual = BinaryTreeHeight.height(root);
        assertEquals(expected, actual);
    }

    @Test
    public void heightReturnsOneForSingleLevelTree() {
        Node root = BinaryTreeHeight.constructTree(new int[]{5, 3});
        int expected = 1;
        int actual = BinaryTreeHeight.height(root);
        assertEquals(expected, actual);
    }

    @Test
    public void heightReturnsCorrectlyForMultiLevelTree() {
        Node root = BinaryTreeHeight.constructTree(new int[]{3, 5, 2, 1});
        int expected = 2;
        int actual = BinaryTreeHeight.height(root);
        assertEquals(expected, actual);
    }
}


