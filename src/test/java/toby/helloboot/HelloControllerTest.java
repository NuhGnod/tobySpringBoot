package toby.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HelloControllerTest {

    @Test
    void helloController() {
        HelloController helloController = new HelloController(name -> name);
        String res = helloController.hello("spring");

        assertThat(res).isEqualTo("spring");

    }

    @Test
    void fail() {
        HelloController helloController = new HelloController(name -> name);
        assertThatThrownBy(() -> {
            String res = helloController.hello(null);

        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            String res = helloController.hello("");

        }).isInstanceOf(IllegalArgumentException.class);
    }

}
