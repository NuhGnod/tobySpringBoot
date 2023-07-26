package tobyspring.config;

import org.springframework.context.annotation.Import;
import tobyspring.config.autoconfig.DispatcherServletConfig;
import tobyspring.config.autoconfig.TomcatWebServerConfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//@Import({DispatcherServletConfig.class, TomcatWebServerConfig.class}) //Componet 애노테이션 붙은 클래스를 import해옴.
@Import(MyAutoConfigImportSelector.class) //Componet 애노테이션 붙은 클래스를 import해옴.
public @interface EnableMyAutoConfiguration {
}
