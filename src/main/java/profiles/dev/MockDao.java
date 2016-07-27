package profiles.dev;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import profiles.Dao;

/**
 * Created by Evegeny on 27/07/2016.
 */
@Repository
@Profile("DEV")
public class MockDao implements Dao {
    @Override
    public void save() {
        System.out.println("mocking...");
    }
}
