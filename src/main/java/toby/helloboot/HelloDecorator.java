package toby.helloboot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class HelloDecorator implements HelloService {

    private final HelloService helloService;

    public HelloDecorator(@Qualifier("simple") HelloService helloService) {
        this.helloService = helloService;
    }


    @Override
    public String say(String name) {
        return helloService.say(name) + "*";
    }
}
