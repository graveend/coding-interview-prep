package arrays.easy;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/find-the-pivot-integer/description/
 */
public class FindPivotInteger {
    public static int pivotInteger(int n) {
        int i = 1, j = n;
        int x = -1;
        int leftSum = 0, rightSum = 0;
        while(i <= j) {
            if(leftSum == rightSum && i == j ) {
                return j;
            }
            if( leftSum < rightSum) {
                leftSum += i;
                i++;
            } else {
                rightSum += j;
                j--;
            }
        }
        return x;
    }
}

class TestFindPivotInteger {
    @Test
    public void testPivotInteger() {
        int n = 8;
        int expected = 6;
        int output = FindPivotInteger.pivotInteger(n);
        assertEquals(expected, output);
    }

    @Test
    public void testPivotInteger1() {
        int n = 1;
        int expected = 1;
        int output = FindPivotInteger.pivotInteger(n);
        assertEquals(expected, output);
    }
}
