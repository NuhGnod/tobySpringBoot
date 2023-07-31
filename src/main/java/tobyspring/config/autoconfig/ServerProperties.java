package tobyspring.config.autoconfig;

import org.springframework.stereotype.Component;

@Component
@MyConfigurationProperties(prefix = "server")
public class ServerProperties {
    private String contextPath;

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    private int port;

}
