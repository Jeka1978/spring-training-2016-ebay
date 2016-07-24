package quoters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 24/07/2016.
 */


@PropertySource("classpath:quotes.properties")
@Configuration
public class Config {

    @PostConstruct
    public void x() {
        System.out.println(123);
    }

    /*@Bean
    public static PropertySourcesPlaceholderConfigurer configurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }*/
}
