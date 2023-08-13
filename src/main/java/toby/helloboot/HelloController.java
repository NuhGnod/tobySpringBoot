package toby.helloboot;


import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RequestMapping("/hello")
//@RestController
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    @ResponseBody
    public String hello(String name) {
        Objects.requireNonNull(name);
        return helloService.say(name);
    }
}
