package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@UnitTest
@interface FastUnitTest{

}


@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Test
@interface UnitTest{

}
public class HelloServiceTest {

    @FastUnitTest
    void simpleHelloService() {
        SimpleHelloService simpleHelloService = new SimpleHelloService(new HelloRepository() {
            @Override
            public Hello findHello(String name) {
                return null;
            }

            @Override
            public void increaseCount(String name) {

            }
        });
        String test = simpleHelloService.sayHello("Test");
        Assertions.assertThat(test).isEqualTo("HelloTest");
    }

    @Test
    void helloDecorator() {
        HelloDecorator helloDecorator = new HelloDecorator(name -> name);
        String test = helloDecorator.sayHello("Test");
        Assertions.assertThat(test).isEqualTo("*Test*");
    }
}
