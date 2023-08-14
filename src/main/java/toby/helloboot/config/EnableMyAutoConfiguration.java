package toby.helloboot.config;

import org.springframework.context.annotation.Import;
import toby.helloboot.config.autoconfig.DispatcherServletConfig;
import toby.helloboot.config.autoconfig.TomcatWebServerConfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
//@Import({DispatcherServletConfig.class, TomcatWebServerConfig.class})
@Import(MyAutoConfigImportSelector.class)
public @interface EnableMyAutoConfiguration {

}
