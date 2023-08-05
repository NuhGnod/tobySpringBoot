package tobyspring.helloboot;

import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import tobyspring.config.MySpringBootApplication;

import javax.annotation.PostConstruct;

//@Configuration
//@ComponentScan
//@SpringBootApplication
@MySpringBootApplication
public class HellobootApplication {
    //    @Bean
//    ApplicationRunner applicationRunner(Environment env) {
//        return args -> {
//            String property = env.getProperty("my.name");
//            System.out.println("property = " + property);
//        };
//    }
    private final JdbcTemplate jdbcTemplate;

    public HellobootApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PostConstruct
    void init(){
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }

    public static void main(String[] args) {
//        MySpringApplication.run(HellobootApplication.class, args);
        SpringApplication.run(HellobootApplication.class, args);
    }


}
