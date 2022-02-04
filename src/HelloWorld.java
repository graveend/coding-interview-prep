import java.util.function.Function;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class HelloWorld {
    public static Function<String, String> helloWorldMethod = name -> String.format("Hello %s!", name);
}

class HelloWorldTest {
    @Test
    public void TestHelloWorld() {
        Assert.assertEquals("Hello Molly!", HelloWorld.helloWorldMethod.apply("Molly"));
    }
}
