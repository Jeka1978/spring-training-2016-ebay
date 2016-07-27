package conditional.conf;/**
 * Created by Evegeny on 27/07/2016.
 */

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Conditional(ProdEnvironmentDetector.class)
public @interface Prod {
}
