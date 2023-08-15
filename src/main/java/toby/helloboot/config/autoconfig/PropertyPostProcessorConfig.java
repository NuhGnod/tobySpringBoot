package toby.helloboot.config.autoconfig;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;
import org.springframework.util.ClassUtils;
import toby.helloboot.config.MyAutoConfiguration;
import toby.helloboot.config.MyPropertiesConfiguration;

import java.util.Map;

@MyAutoConfiguration
public class PropertyPostProcessorConfig {
    @Bean
    public BeanPostProcessor beanPostProcessor(Environment env) {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                MyPropertiesConfiguration annotation = AnnotationUtils.findAnnotation(bean.getClass(), MyPropertiesConfiguration.class);
                if (annotation == null) {
                    return bean;
                }

                Map<String, Object> attrs = AnnotationUtils.getAnnotationAttributes(annotation);
                String prefix = (String) attrs.get("prefix");

                return Binder.get(env).bindOrCreate(prefix, bean.getClass());
            }
        };
    }
}
