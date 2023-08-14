package toby.helloboot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("complex")
public class ComplexHelloService implements HelloService{
    @Override
    public String say(String name) {
        return null;
    }
}
