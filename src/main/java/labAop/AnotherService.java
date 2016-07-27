package labAop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 27/07/2016.
 */
@Service
public class AnotherService {
    @Autowired
    private SomeService someService;
    public void doSomething() {
        someService.doX();
    }
}
