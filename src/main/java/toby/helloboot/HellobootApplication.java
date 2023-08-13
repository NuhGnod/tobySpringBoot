package toby.helloboot;

import org.apache.catalina.core.ApplicationContext;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@SpringBootApplication
public class HellobootApplication {

    public static void main(String[] args) {
//		SpringApplication.run(HellobootApplication.class, args);
        // spring container 생성 후 Bean 초기화
        GenericWebApplicationContext container = new GenericWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();
                ServletWebServerFactory factory = new TomcatServletWebServerFactory(); // 어떤 servletContainer를 동작시킬 수 있으니,

                WebServer webServer = factory.getWebServer(servletContext -> {
                    servletContext.addServlet("dispatcherServlet", new DispatcherServlet(this))
                            .addMapping("/*");
                });

                webServer.start();

            }
        };
        container.registerBean(HelloController.class);
        container.registerBean(SimpleHelloService.class);
        container.refresh();

        // 추상화.

        // DispatcherServlet 초기화.
    }

}
