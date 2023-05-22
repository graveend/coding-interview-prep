package trees;

import org.junit.jupiter.api.Test;

import java.util.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TreeUtils {
    /**
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode preAndInTree(int[] preorder, int[] inorder) {
        return preInBuildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    /**
     *
     * @param postorder
     * @param inorder
     * @return
     */
    public static TreeNode postAndInTree(int[] postorder, int[] inorder) {
        return postInBuildTree(postorder, inorder, postorder.length - 1, 0, inorder.length - 1);
    }

    /**
     *
     * @param preorder
     * @param inorder
     * @param preStart
     * @param inStart
     * @param inEnd
     * @return
     */
    public static TreeNode preInBuildTree(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if(preStart > preorder.length || inStart > inEnd ) return null;

        // create root node
        TreeNode root = new TreeNode(preorder[preStart]);

        // find the index in inorder
        int index = inStart;
        for(int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == preorder[preStart]) index = i;
        }

        root.left = preInBuildTree(preorder, inorder, preStart+1, inStart, index-1);
        root.right = preInBuildTree(preorder, inorder, preStart + (index - inStart+1), index+1, inEnd);

        return root;
    }

    /**
     *
     * @param postorder
     * @param inorder
     * @param postEnd
     * @param inStart
     * @param inEnd
     * @return
     */
    public static TreeNode postInBuildTree(int[] postorder, int[] inorder, int postEnd, int inStart, int inEnd) {
        if(postEnd < 0 || inStart > inEnd ) return null;

        // create root node
        TreeNode root = new TreeNode(postorder[postEnd]);

        // find the index in inorder
        int index = inStart;
        for(int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == postorder[postEnd]) index = i;
        }   // 4 - ( 4 - 1) = 1

        root.left = postInBuildTree(postorder, inorder, postEnd - (inEnd - index) - 1, inStart, index-1);
        root.right = postInBuildTree(postorder, inorder, postEnd - 1, index+1, inEnd);

        return root;
    }

    public static List<Integer> bfsListOfTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        bfsListOfTree(root, list);
        return list;
    }
    public static void bfsListOfTree(TreeNode root, List<Integer> list) {
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            list.add((current != null ? current.val: null));
            if(current != null) {
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }
    }

    public static void printTree(TreeNode node, String prefix, boolean isLeft) {
        if (node == null) {
            return;
        }

        System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.val);

        printTree(node.left, prefix + (isLeft ? "│   " : "    "), true);
        printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
    }

}

class TestTreeUtils {
    @Test
    public void testPreAndInBuildTree() {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode root = TreeUtils.preAndInTree(preorder, inorder);
        List<Integer> output = TreeUtils.bfsListOfTree(root);
        List<Integer> expected = Arrays.asList(3,9,20,null,null,15,7, null, null, null, null);
        TreeUtils.printTree(root, "", false);
        assertTrue(expected.equals(output));
    }

    @Test
    public void testPostAndInBuildTree() {
        int[] postorder = new int[]{9,15,7,20,3};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode root = TreeUtils.postAndInTree(postorder, inorder);
        List<Integer> output = TreeUtils.bfsListOfTree(root);
        List<Integer> expected = Arrays.asList(3,9,20,null,null,15,7, null, null, null, null);
        TreeUtils.printTree(root, "", false);
        assertTrue(expected.equals(output));
    }
}
