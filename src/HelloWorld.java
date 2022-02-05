import java.util.function.Function;
import org.junit.jupiter.api.Test;
import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorld {
    public static Function<String, String> helloWorldMethod = name -> {
        String result = String.format("Hello %s!", name);
        System.out.print(result);
        return result;
    };
}

class HelloWorldJavaTest {
    @Test
    public void helloWorldReturnsPersonalizedMessage() {
        String expected = "Hello Molly!";
        String returned = HelloWorld.helloWorldMethod.apply("Molly");
        assertEquals(expected, returned);
    }

    @Test
    public void helloWorldPrintsPersonalizedMessage() throws Exception {
        String expected = "Hello Molly!";
        String returned = tapSystemOut(() -> HelloWorld.helloWorldMethod.apply("Molly"));
        assertEquals(expected, returned);
    }
}
