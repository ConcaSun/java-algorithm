package com.usoft.suntg.algorithm.patterns.cache;

/**
 * Created by ConcaSun on 2019/5/26.
 */
public class CacheContext implements CacheContainer {

    private CacheContainer cacheContainer;

    public CacheContext(CacheContainer cacheContainer) {
        this.cacheContainer = cacheContainer;
    }

    @Override
    public void put(String key, Object value) {
        cacheContainer.put(key, value);
    }

    @Override
    public Object get(String key) {
        return cacheContainer.get(key);
    }
}
