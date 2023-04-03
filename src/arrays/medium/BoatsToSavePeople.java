package arrays.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/boats-to-save-people/description/s
 */
public class BoatsToSavePeople {
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1, sum = 0, count = 0;
        while( i <= j ) {
            count++;
            if(people[j] + people[i] <= limit) {
                i++;
            }
            j--;
        }
        return count;
    }
}

class TestBoatsToSavePeople {

    @Test
    public void testBoats() {
        int[] people = new int[]{1,2};
        int limit = 3;
        int expected = 1;
        int output = BoatsToSavePeople.numRescueBoats(people, limit);
        assertEquals(expected, output);
    }
}
