import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorld {
    public static Function<String, String> helloWorldMethod = name -> String.format("Hello %s!", name);
}

class HelloWorldTest {
    @Test
    public void TestHelloWorld() {
        assertEquals("Hello Molly!", HelloWorld.helloWorldMethod.apply("Molly"));
    }
}