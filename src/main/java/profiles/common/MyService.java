package profiles.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import profiles.Dao;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 27/07/2016.
 */
@Service
public class MyService {
    @Autowired
    private Dao dao;

    @Value("${name}")
    private String name;

    @PostConstruct
    public void stam(){
        dao.save();
        System.out.println(name);
    }
}
