package toby.helloboot.config.autoconfig;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.embedded.jetty.JettyWebServer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;
import toby.helloboot.config.ConditionalMyOnClass;
import toby.helloboot.config.MyAutoConfiguration;

@MyAutoConfiguration
//@Conditional(JettyWebServerConfig.JettyCondition.class)
@ConditionalMyOnClass("org.eclipse.jetty.server.Server")
public class JettyWebServerConfig {

    @Bean("jettyWebServerFactory")
    public ServletWebServerFactory servletWebServerFactory() {
        return new JettyServletWebServerFactory();
    }

}
