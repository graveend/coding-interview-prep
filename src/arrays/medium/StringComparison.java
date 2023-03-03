package arrays.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringComparison {
    public static int compress(char[] chars) {
        int i = 0, index = 0;
        int N = chars.length;
        while(i < N) {
            int count = 1;
            while(i < N-1 && chars[i] == chars[i+1]) {
                i++;
                count++;
            }
            chars[index++] = chars[i++];
            if(count != 1) {
                for(char c : Integer.toString(count).toCharArray()) {
                    chars[index++] =  c;
                }
            }
        }
        return index;
    }
}

class TestStringComparison {

    @Test
   public void testString() {
       char[] input = new char[]{'a','a','b','b','c','c','c'};
       int expected = 6;
       int output = StringComparison.compress(input);
       assertEquals(expected,output);
   }

    @Test
    public void testString1() {
        char[] input = new char[]{'a'};
        int expected = 1;
        int output = StringComparison.compress(input);
        assertEquals(expected,output);
    }

    @Test
    public void testString2() {
        char[] input = new char[]{'a', 'b', 'c'};
        int expected = 3;
        int output = StringComparison.compress(input);
        assertEquals(expected,output);
    }
}

