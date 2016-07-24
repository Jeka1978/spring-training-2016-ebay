package quoters;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import screenSaver.ScreenSaverConfig;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 24/07/2016.
 */


@PropertySource("classpath:quotes.properties")
@Configuration
@ComponentScan(basePackages = "quoters")
@EnableAspectJAutoProxy
public class Config {


}
