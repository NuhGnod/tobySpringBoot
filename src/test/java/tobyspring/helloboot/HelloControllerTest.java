package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloControllerTest {
    @Test
    void helloController() {
        HelloController helloController = new HelloController(new HelloService() {
            @Override
            public String sayHello(String name) {
                return name;
            }
        });
        String test = helloController.hello("Test");
        Assertions.assertThat(test).isEqualTo("Test");
    }

    @Test
    void failsHelloController() {
        HelloController helloController = new HelloController(new HelloService() {
            @Override
            public String sayHello(String name) {
                return name;
            }
        });
        Assertions.assertThatThrownBy(() -> {
            String hello = helloController.hello(null);

        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            String hello = helloController.hello("");

        }).isInstanceOf(IllegalArgumentException.class);
    }
}
