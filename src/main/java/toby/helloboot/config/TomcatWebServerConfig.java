package toby.helloboot.config;

import com.fasterxml.jackson.databind.util.ClassUtil;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.*;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;
import toby.helloboot.config.ConditionalMyOnClass;
import toby.helloboot.config.MyAutoConfiguration;
import toby.helloboot.config.autoconfig.EnableMyConfigurationProperties;
import toby.helloboot.config.autoconfig.ServerProperties;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
//@Import(ServerProperties.class)
@EnableMyConfigurationProperties(ServerProperties.class)
public class TomcatWebServerConfig {

    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory(ServerProperties serverProperties) {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.setContextPath(serverProperties.getContextPath());
        tomcat.setPort(serverProperties.getPort());

        return tomcat;
    }

}
