package toby.helloboot.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {


    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                "toby.helloboot.config.autoconfig.DispatcherServletConfig",
                "toby.helloboot.config.autoconfig.TomcatWebServerConfig"
        };
    }
}
