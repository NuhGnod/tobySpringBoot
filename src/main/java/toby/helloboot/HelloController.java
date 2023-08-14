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
    private final ApplicationContext applicationContext;
    public HelloController(HelloService helloService, ApplicationContext applicationContext) {
        this.helloService = helloService;
        this.applicationContext = applicationContext;

        System.out.println("applicationContext = " + applicationContext);
    }

    @GetMapping
    @ResponseBody
    public String hello(String name) {
        Objects.requireNonNull(name);
        return helloService.say(name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
