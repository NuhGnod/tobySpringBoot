package toby.helloboot.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;
import toby.helloboot.config.autoconfig.EnableMyConfigurationProperties;

public class MyConfigurationPropertiesImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        MultiValueMap<String, Object> attrs = importingClassMetadata.getAllAnnotationAttributes(EnableMyConfigurationProperties.class.getName());
        Class value = (Class) attrs.getFirst("value");
        return new String[]{value.getName()};

    }
}
