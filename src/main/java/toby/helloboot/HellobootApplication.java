package toby.helloboot;

import org.apache.catalina.core.ApplicationContext;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

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

        ServletWebServerFactory factory = new TomcatServletWebServerFactory(); // 어떤 servletContainer를 동작시킬 수 있으니,
        // 추상화.

        WebServer webServer = factory.getWebServer(servletContext -> {
            servletContext.addServlet("frontController", new HttpServlet() {
                        @Override
                        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                            if (req.getRequestURI().equals("/hello")
                                    && req.getMethod().equals(HttpMethod.GET.name())) {

                                String name = req.getParameter("name");
                                resp.setStatus(HttpStatus.OK.value());
                                resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
                                resp.getWriter().println("simpleServlet name : " + name);
                            } else {
                                resp.setStatus(HttpStatus.NOT_FOUND.value());

                            }
                        }
                    })
                    .addMapping("/*");
        });
        webServer.start();

    }

}
