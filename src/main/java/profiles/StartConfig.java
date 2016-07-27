package profiles;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Evegeny on 27/07/2016.
 */
@Configuration
@ComponentScan(basePackages = "profiles.common")
@ComponentScan(basePackages = "profiles.conf")
public class StartConfig {
}
