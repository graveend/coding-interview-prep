import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

fun helloWorld(name: String = "World"): String {
    return "Hello, ${name}!"
}

class Test {
    @Test
    fun helloWorldReturnsPersonalizedMessage() {
        assertEquals("Hello, Molly!", helloWorld("Molly"))
    }

    @Test
    fun helloWorldReturnsGenericMessage() {
        assertEquals("Hello, World!", helloWorld())
    }
}
