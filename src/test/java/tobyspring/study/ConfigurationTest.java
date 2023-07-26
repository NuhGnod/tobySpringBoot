package tobyspring.study;

import org.apache.catalina.core.ApplicationContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigurationTest {
    @Test
    void configuration() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);
//        annotationConfigApplicationContext.register(MyConfiguration.class);
//        annotationConfigApplicationContext.refresh();
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinition : beanDefinitionNames) {
            // 빈 이름으로 빈 객체(인스턴스)를 조회한다.
            Object bean = ac.getBean(beanDefinition);
            System.out.println("beanDefinition = " + beanDefinition + ", object = " + bean);
        }
        MyConfiguration myConfiguration = new MyConfiguration();
//        Bean1 bean1 = myConfiguration.bean1();
//        Bean2 bean2 = myConfiguration.bean2();
//        Assertions.assertThat(bean1.common).isSameAs(bean2.common);
        Bean1 bean1 = ac.getBean(Bean1.class);
        Bean2 bean2 = ac.getBean(Bean2.class);
        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);
        System.out.println("bean1.coi = " + bean1.common);
        System.out.println("bean2.coi = " + bean2.common);
        Assertions.assertThat(bean1.common).isSameAs(bean2.common);
    }

    @Test
    void proxyCommonMethod() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinition : beanDefinitionNames) {
            // 빈 이름으로 빈 객체(인스턴스)를 조회한다.
            Object bean = ac.getBean(beanDefinition);
            System.out.println("beanDefinition = " + beanDefinition + ", object = " + bean);
        }
        MyConfigProxy myConfigProxy = new MyConfigProxy();

        Bean1 bean1 = myConfigProxy.bean1();
        Bean2 bean2 = myConfigProxy.bean2();
        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);

        System.out.println("bean1.coi = " + bean1.common);
        System.out.println("bean2.coi = " + bean2.common);
        Assertions.assertThat(bean1.common).isSameAs(bean2.common);
    }

    static class MyConfigProxy extends MyConfiguration {
        private Common common;

        @Override
        Common common() {
            if (common == null) common = super.common();
            return common;
        }
    }

    @Configuration
//    @Configuration(proxyBeanMethods = false)
    static class MyConfiguration {
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
