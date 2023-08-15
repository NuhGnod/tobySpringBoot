package toby.helloboot.config.autoconfig;

import com.fasterxml.jackson.databind.util.ClassUtil;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;
import toby.helloboot.config.ConditionalMyOnClass;
import toby.helloboot.config.MyAutoConfiguration;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {

    @Bean("tomcatWebServerFactory")
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }

}
