package conditional.prod;

import conditional.Dao;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;


/**
 * Created by Evegeny on 27/07/2016.
 */
@Repository
public class ProdDao implements Dao {
    @Override
    public void save() {
        System.out.println("Saving...");
    }
}
