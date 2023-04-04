package arrays.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/optimal-partition-of-string/description/
 */
public class OptimalPartitionOfKey {
    public static int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, ans = 1;
        while( i < s.length()) {
            char curr = s.charAt(i);
            if(set.contains(curr)) {
                ans++;
                set.clear();
            }
            set.add(curr);
            i++;

        }
        return ans;
    }
}

class TestOptimalPartitionOfKey {

    @Test
    public void testKey() {
        String s = "ababc";
        int expected = 2;
        int output = OptimalPartitionOfKey.partitionString(s);
        assertEquals(expected, output);
    }

    @Test
    public void testKey1() {
        String s = "sssss";
        int expected = 5;
        int output = OptimalPartitionOfKey.partitionString(s);
        assertEquals(expected, output);
    }
}
