package conditional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Evegeny on 27/07/2016.
 */
@Configuration
@ComponentScan(basePackages = "conditional.common")
@ComponentScan(basePackages = "conditional.conf")
public class StartConfig {
}
