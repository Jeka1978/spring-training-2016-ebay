package conditional.dev;

import conditional.Dao;
import org.springframework.stereotype.Repository;


/**
 * Created by Evegeny on 27/07/2016.
 */
@Repository
public class MockDao implements Dao {
    @Override
    public void save() {
        System.out.println("mocking...");
    }
}
