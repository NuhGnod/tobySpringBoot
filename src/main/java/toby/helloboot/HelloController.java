package toby.helloboot;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
@RestController
@RequestMapping("/hello")
//@RestController
public class HelloController implements ApplicationContextAware {

    private final HelloService helloService;
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    @ResponseBody
    public String hello(String name) {
        if(name == null  || name.length()== 0) throw new IllegalArgumentException();
//        Objects.requireNonNull(name);
        return helloService.say(name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
