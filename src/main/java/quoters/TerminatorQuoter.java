package quoters;

import com.google.common.annotations.Beta;
import mySpring.Benchmark;
import mySpring.Transcational;
import neveruseswitch.Log;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Evegeny on 17/07/2016.
 */
@Benchmark
@Transcational
@Component
@Book
public class TerminatorQuoter implements Quoter {

    private List<String> messages;


    @Value("${terminator}")
    public void setMessages(String[] messages, @Value("${JAVA_HOME}") String javaHome) {
        System.out.println("javaHome = " + javaHome);
        this.messages = Arrays.asList(messages);
    }

    @PreDestroy
    public void killAll() {
        System.out.println("You are terminated...");
    }

    @Override
    @Log
    public void sayQuote() {
        messages.forEach(System.out::println);
    }
}
