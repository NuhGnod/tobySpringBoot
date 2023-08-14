package toby.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloServiceTest {
    @Test
    void SimpleHelloService() {
        SimpleHelloService simpleHelloService = new SimpleHelloService();
        String res = simpleHelloService.say("spring");
        assertThat(res).isEqualTo("simpleHelloService : spring");
    }

    @Test
    void HelloDecorator() {
        HelloDecorator helloDecorator = new HelloDecorator(name -> name);
        String res = helloDecorator.say("spring");
        assertThat(res).isEqualTo("spring*");
    }
}
