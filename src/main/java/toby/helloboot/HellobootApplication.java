package toby.helloboot;

import org.apache.catalina.core.ApplicationContext;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

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

		WebServer webServer = factory.getWebServer( servletContext -> {
			servletContext.addServlet("simpleServlet", new HttpServlet() {
						@Override
						protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
							resp.setStatus(200);
							resp.setContentType("application/json");
							resp.getWriter().println("Hello servlet");

						}
					})
					.addMapping("/hello");
		});
		webServer.start();

	}

}
