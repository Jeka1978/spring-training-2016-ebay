package screenSaver;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import javafx.util.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import static java.time.LocalDateTime.now;

/**
 * Created by Evegeny on 24/07/2016.
 */
public class TwoSecondsScopeProvider implements Scope {

    private Cache<String, Object> cache;

    {
        cache = CacheBuilder.newBuilder().expireAfterWrite(2, TimeUnit.SECONDS).build();
    }
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (!cache.asMap().containsKey(name)) {
            cache.put(name, objectFactory.getObject());
        }
        return cache.asMap().get(name);
    }

   


    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
