package labAop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Evegeny on 27/07/2016.
 */
@Configuration
@EnableAspectJAutoProxy
@PropertySource("classpath:mail.properties")
public class Conf {
    @Bean
    public String s(){
        return "p";
    }
}
