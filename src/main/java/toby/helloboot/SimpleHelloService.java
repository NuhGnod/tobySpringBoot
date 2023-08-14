package toby.helloboot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
@Qualifier("simple")
public class SimpleHelloService implements HelloService {

    @Override
    public String say(String name) {
        return "simpleHelloService : " + name;
    }
}
