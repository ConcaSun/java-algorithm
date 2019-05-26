package com.usoft.suntg.algorithm.patterns.cache;

/**
 * Created by ConcaSun on 2019/5/26.
 */
public interface CacheContainer {

    public void put(String key, Object value);

    public Object get(String key);

}
