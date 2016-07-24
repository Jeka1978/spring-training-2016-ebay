package neveruseswitch;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Evegeny on 24/07/2016.
 */
@Configuration
@EnableScheduling
@ComponentScan(basePackages = "neveruseswitch")
public class Config {

}
