package arrays.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/fibonacci-number/description/
 */
public class FibonacciNumber {
    public static int fib(int n) {
        if(n == 0) return 0;
        int i = 2;
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        while(i <= n) {
            arr[i] = arr[i-1] + arr[i-2];
            i++;
        }
        return arr[n];
    }
}

class TestFibonacciNumber {
    @Test
    public void testFibonacci() {
        int input = 2;
        int expected = 1;
        int output = FibonacciNumber.fib(input);
        assertEquals(expected, output);
    }

    @Test
    public void testFibonacci1() {
        int input = 0;
        int expected = 0;
        int output = FibonacciNumber.fib(input);
        assertEquals(expected, output);
    }

    @Test
    public void testFibonacci2() {
        int input = 4;
        int expected = 3;
        int output = FibonacciNumber.fib(input);
        assertEquals(expected, output);
    }
}
