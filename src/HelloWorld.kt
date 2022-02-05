import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

fun helloWorld(name: String = "World"): String {
    return "Hello, ${name}!"
}

class HelloWorldKotlinTest {
    @Test
    fun helloWorldReturnsPersonalizedMessage() {
        val expected = "Hello, Molly!"
        val returned = helloWorld("Molly")
        assertEquals(expected, returned)
    }

    @Test
    fun helloWorldReturnsGenericMessage() {
        val expected = "Hello, World!"
        val returned = helloWorld()
        assertEquals(expected, returned)
    }
}
