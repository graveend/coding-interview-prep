package arrays;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzz {
    public String getFizzbuzz(int n) {
        List<String> strList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0)
                strList.add("FizzBuzz");
            else if (i % 5 == 0)
                strList.add("Buzz");
            else if (i % 3 == 0)
                strList.add("Fizz");
            else
                strList.add(String.valueOf(i));
        }
        return String.join(" ", strList);
    }
}

class FizzBuzzTest {
    @Test
    public void testMethod() {
        int n = 15;
        String received = new FizzBuzz().getFizzbuzz(n);
        String expected = "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz";
        assertEquals(received, expected);
    }
}
