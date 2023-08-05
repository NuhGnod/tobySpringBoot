package tobyspring.helloboot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // HelloController가 필요한 Bean이 2개 이상일 떄 우선순위를 가짐.
public class HelloDecorator implements HelloService {
    private final HelloService helloService;

    public HelloDecorator(HelloService helloService) { //Autowiring 이 될때, 자신을 제외한 HelloService Bean은 Simple1개만 남은상태라 자동 주입된다.
        this.helloService = helloService;
    }

    @Override
    public String sayHello(String name) {
        return "*" + helloService.sayHello(name) + "*";
    }

    @Override
    public int countOf(String name) {
        return helloService.countOf(name);
    }
}
