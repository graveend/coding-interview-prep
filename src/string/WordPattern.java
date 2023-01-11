package string;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * https://leetcode.com/problems/word-pattern/description/
 */
public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        Map<String, Character> map = new HashMap<>();
        String[] words = s.split(" ");
        char[] ch = pattern.toCharArray();
        for(int i = 0; i < words.length; i++) {
            if( map.containsKey(words[i]) ) {
                if(!map.get(words[i]).equals(ch[i])) {
                    return false;
                }
            } else {
                if(map.containsValue(ch[i])) {
                    return false;
                }
                map.put(words[i], ch[i]);
            }
        }

        return true;
    }
}

class TestWordPattern {

    @Test
    public void testWordPattern1() {
        String s = "dog cat cat fish";
        String pattern = "abba";
        assertFalse(WordPattern.wordPattern(pattern,s));
    }

    @Test
    public void testWordPattern2() {
        String s = "dog cat cat dog";
        String pattern = "abba";
        assertTrue(WordPattern.wordPattern(pattern,s));
    }
}
