package toby.helloboot.config.autoconfig;

import toby.helloboot.config.MyPropertiesConfiguration;

//@Component
@MyPropertiesConfiguration(prefix = "server")
public class ServerProperties {
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
//    @Value("${contextPath}")
    private String contextPath;
//    @Value("${port}")
    private int port;
}
