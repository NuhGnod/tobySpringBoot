package toby.helloboot;

import org.springframework.stereotype.Service;

//@Service
public class SimpleHelloService implements HelloService {

    @Override
    public String say(String name) {
        return "simpleHelloService : " + name;
    }
}
