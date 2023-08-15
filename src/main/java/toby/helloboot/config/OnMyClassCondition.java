package toby.helloboot.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;

public class OnMyClassCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attrs = metadata.getAnnotationAttributes(ConditionalMyOnClass.class.getName());
        String value = (String) attrs.get("value");
        return ClassUtils.isPresent(value, context.getClassLoader());
    }
}
