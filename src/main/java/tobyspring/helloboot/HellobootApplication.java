package tobyspring.helloboot;

import org.springframework.boot.SpringApplication;
import tobyspring.config.MySpringBootApplication;

//@Configuration
//@ComponentScan
//@SpringBootApplication
@MySpringBootApplication
public class HellobootApplication {


    public static void main(String[] args) {
//        MySpringApplication.run(HellobootApplication.class, args);
        SpringApplication.run(HellobootApplication.class, args);
    }


}
