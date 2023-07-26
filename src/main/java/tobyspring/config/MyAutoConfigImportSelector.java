package tobyspring.config;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

public class MyAutoConfigImportSelector implements DeferredImportSelector {
    private final ClassLoader classLoader;

    public MyAutoConfigImportSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//        System.out.println("importingClassMetadata = " + importingClassMetadata);
//        return new String[]{
//                "tobyspring.config.autoconfig.DispatcherServletConfig",
//                "tobyspring.config.autoconfig.TomcatWebServerConfig"
//        };
        List<String> autoConfigs = new ArrayList<>();
        System.out.println("ASDASDASDDDDDDDDDDDDDDDDDDDDDD");
        // java5
//        for (String candidate : ImportCandidates.load(MyAutoConfiguration.class, classLoader)) {
//            autoConfigs.add(candidate);
//        }
        // java8
//        ImportCandidates.load(MyAutoConfiguration.class, classLoader).forEach(cadidate -> {
//            autoConfigs.add(cadidate);
//        });
        // improved java 8
        ImportCandidates.load(MyAutoConfiguration.class, classLoader).forEach(autoConfigs::add);



//        Iterable<String> candidates = ImportCandidates.load(MyAutoConfiguration.class, classLoader);
//        return StreamSupport.stream(candidates.spliterator(), false).toArray(String[]::new);
//        return autoConfigs.stream().toArray(String[]::new);
        System.out.println("ASDASDASDDDDDDDDDDDDDDDDDDDDDD");

        return autoConfigs.toArray(new String[0]);
    }
}
