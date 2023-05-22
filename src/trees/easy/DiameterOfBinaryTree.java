package trees.easy;

import org.junit.jupiter.api.Test;
import trees.TreeNode;
import trees.TreeUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiameterOfBinaryTree {
    public static int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int diameter = depth(root.left) + depth(root.right);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        return Math.max(diameter, Math.max(left, right));
    }

    private static int depth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}

class TestDiameterOfBinaryTree {
    @Test
    public void testDiameter() {
        int[] preorder = new int[]{1,2,4,5,3}, inorder = new int[]{4,2,5,1,3};
        TreeNode root = TreeUtils.preAndInTree(preorder, inorder);
        int expected = 3;
        int actual = DiameterOfBinaryTree.diameterOfBinaryTree(root);
        assertEquals(expected, actual);
    }
}
