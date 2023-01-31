package arrays.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/longest-subsequence-with-limited-sum/description/
 */
public class LongestSubsequenceWithLimitedSum {
    public static int[] answerQueries(int[] A, int[] queries) {
        Arrays.sort(A);
        int n = A.length, m = queries.length, res[] = new int[m];
        for (int i = 1; i < n; ++i)
            A[i] += A[i - 1];
        for (int i = 0; i < m; ++i) {
            int j = Arrays.binarySearch(A, queries[i]);
            res[i] = Math.abs(j + 1);
        }
        return res;
    }
}

class TestLongestSubsequenceWithLimitedSum {

    @Test
    public void testLongestSubsequence() {
        int[] nums = new int[]{4,5,2,1};
        int[] queries = new int[]{3,10,21};
        int[] expected = new int[]{2,3,4};
        int[] output = LongestSubsequenceWithLimitedSum.answerQueries(nums, queries);
        assertEquals(expected, output);
    }
}
