package labAop;

import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 27/07/2016.
 */
@Service
public class SomeService {
    public void doX() {
        System.out.println("started...");
        throw new DBRuntimeException("fire all dba!!! db sucks!");
    }
}
