package conditional.conf;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by Evegeny on 27/07/2016.
 */
public class ProdEnvironmentDetector implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String env = EnvFramework.getEnv();
        return env.equalsIgnoreCase("prod");
    }
}
