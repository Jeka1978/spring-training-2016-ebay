package labAop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 27/07/2016.
 */
@Service
public class OneService {
    @Autowired
    private OneService proxy;

    public void doX(){
        proxy.doY();
    }

    @Deprecated
    public void doY() {
        System.out.println(123);
    }
}
