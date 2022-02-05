// https://www.hackerrank.com/challenges/fizzbuzz/problem

package arrays

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

fun getFizzbuzz(n: Int): String {
    val fizz = "Fizz"
    val buzz = "Buzz"
    val fizzBuzz = "$fizz$buzz"

    val result = mutableListOf<String>()

    for (i in 1..n) {
        if (i % 3 == 0) {
            if (i % 5 == 0) {
                result.add(fizzBuzz)
            } else {
                result.add(fizz)
            }
        } else if (i % 5 == 0) {
            result.add(buzz)
        } else {
            result.add(i.toString())
        }
    }
    return result.joinToString(" ")
}

class Test {

    @Test
    fun testGetFizzBuzz() {
        val n = 15
        val received = getFizzbuzz(n)
        val expected = "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz"
        assertEquals(received, expected)
    }
}
