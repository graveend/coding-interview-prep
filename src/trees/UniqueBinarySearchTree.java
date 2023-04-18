package trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 */
public class UniqueBinarySearchTree {
    static int[] dp = new int[20];
    public static int numTrees(int n) {
        if(n <= 1) return 1;
        if(dp[n] > 0) return dp[n];
        for(int i = 1; i <= n; i++) {
            dp[n] += numTrees(i-1) * numTrees(n-i);
        }
        return dp[n];
    }
}

class TestUniqueBinarySearchTree {
    @Test
    public void testBST() {
        int n = 3;
        int expected = 5;
        int output = UniqueBinarySearchTree.numTrees(n);
        assertEquals(expected, output);
    }

    @Test
    public void testBST1() {
        int n = 1;
        int expected = 1;
        int output = UniqueBinarySearchTree.numTrees(n);
        assertEquals(expected, output);
    }
}
