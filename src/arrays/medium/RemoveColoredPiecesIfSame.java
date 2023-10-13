package arrays.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/description/?envType=daily-question&envId=2023-10-02
 */
public class RemoveColoredPiecesIfSame {
    public static boolean winnerOfGame(String colors) {
        char[] ch = colors.toCharArray();
        int n = colors.length();

        int alice = 0, bob = 0;
        for(int i = 0; i < n; i++) {
            char color = ch[i];
            if(i-1 >= 0 && i+1 < n && ch[i-1] == color && color == ch[i+1]) {
                if(color == 'A') {
                    alice++;
                } else {
                    bob++;
                }
            }
        }
        return alice > bob;

    }
}

class TestRemoveColoredPiecesIfSame {
    @Test
    public void testIfAliceWins() {
        String colors = "AAABABB";
        assertTrue(RemoveColoredPiecesIfSame.winnerOfGame(colors));
    }

    @Test
    public void testIfBobWins() {
        String colors = "AA";
        assertFalse(RemoveColoredPiecesIfSame.winnerOfGame(colors));
    }
}
