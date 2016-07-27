package conditional.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Evegeny on 27/07/2016.
 */
@Dev
@ComponentScan("conditional.dev")
@PropertySource("classpath:dev.properties")
@Configuration
public class DevConfig {

}
