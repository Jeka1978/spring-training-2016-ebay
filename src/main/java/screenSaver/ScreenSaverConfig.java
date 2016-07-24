package screenSaver;

import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

/**
 * Created by Evegeny on 24/07/2016.
 */
@Configuration
public class ScreenSaverConfig {

    @Bean
    @Scope(value = "prototype",proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Color color(){
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }
}
