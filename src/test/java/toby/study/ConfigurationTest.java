package toby.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationTest {

    @Test
    void config() {
        MyConfig myConfig = new MyConfig();
        Bean1 bean1 = myConfig.bean1();
        Bean2 bean2 = myConfig.bean2();
        assertThat(bean1.common).isNotSameAs(bean2.common);

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(MyConfig.class);
        ac.refresh();

        Bean1 acbean1 = ac.getBean(Bean1.class);
        Bean2 acbean2 = ac.getBean(Bean2.class);
        assertThat(acbean1.common).isSameAs(acbean2.common);
    }
    @Configuration
    static class MyConfig {
        @Bean
        Common common() {
            return new Common();
        }

        @Bean
        Bean1 bean1() {
            return new Bean1(common());
        }
        @Bean
        Bean2 bean2() {
            return new Bean2(common());
        }
    }
    static class Bean1 {
        private final Common common;

        Bean1(Common common) {
            this.common = common;
        }
    }
    static class Bean2 {
        private final Common common;

        Bean2(Common common) {
            this.common = common;
        }
    }
    static class Common {

    }
}
