package mySpring;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evegeny on 13/07/2016.
 */
public class JavaConfig implements Config {

    private Map<Class, Class> ifc2ImplClass = new HashMap<>();

    public JavaConfig() {
        ifc2ImplClass.put(Speaker.class, ConsoleSpeaker.class);
        ifc2ImplClass.put(Cleaner.class, PowerCleaner.class);


    }

    @Override
    public Class getImplClass(Class ifc) {
        return ifc2ImplClass.get(ifc);
    }
}
