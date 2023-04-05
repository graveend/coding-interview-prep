package dp.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/solving-questions-with-brainpower/description/
 */
public class QuestionsWithBrainPower {
    public static long mostPoints(int[][] questions) {
        int N = questions.length;
        long[] dp = new long[N];
        for(int i = N-1; i >= 0; i--) {
            int futureIdx = i + questions[i][1] + 1;
            if(futureIdx < N) {
                dp[i] = questions[i][0] + dp[futureIdx];
            } else {
                dp[i] = questions[i][0];
            }
            if(i + 1 < N) {
                dp[i] = Math.max(dp[i+1], dp[i]);
            }
        }
        return dp[0];
    }
}

class TestQuestionsWithBrainPower {

    @Test
    public void testBrainPower() {
        int[][] questions = new int[][]{{5,2},{6,1},{4,4},{2,5}};
        long expected = 8;
        long output = QuestionsWithBrainPower.mostPoints(questions);
        assertEquals(expected, output);
    }
}
