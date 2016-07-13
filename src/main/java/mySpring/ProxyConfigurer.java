package mySpring;

/**
 * Created by Evegeny on 13/07/2016.
 */
public interface ProxyConfigurer {
    Object wrapWithProxy(Object o, Class type);
}
