package com.usoft.suntg.algorithm.pattern.cache;

import com.usoft.suntg.algorithm.patterns.cache.LFUCacheContainer;
import com.usoft.suntg.algorithm.patterns.cache.LRUCacheContainer;
import junit.framework.TestCase;

import static org.junit.Assert.*;

/**
 * Created by ConcaSun on 2019/5/26.
 */
public class CacheContainerTest extends TestCase{

    public void testLRU() {
        LRUCacheContainer cacheContainer = new LRUCacheContainer(4);
        cacheContainer.list();
        cacheContainer.put("user1", "A");
        cacheContainer.put("user2", "B");
        cacheContainer.put("user3", "C");
        cacheContainer.put("user4", "D");
        cacheContainer.list();
        cacheContainer.put("user5", "E");
        cacheContainer.put("user6", "F");
        cacheContainer.list();
        System.out.println("get user4: " + cacheContainer.get("user4"));
        cacheContainer.list();
        System.out.println("get user5: " + cacheContainer.get("user5"));
        cacheContainer.list();
        cacheContainer.put("user6", "FF");
        cacheContainer.list();
    }

    public void testLFU() {
        LFUCacheContainer cacheContainer = new LFUCacheContainer(4);
        cacheContainer.list();
        cacheContainer.put("user1", "A");
        cacheContainer.put("user1", "A");
        cacheContainer.put("user1", "A");
        cacheContainer.put("user1", "A");
        cacheContainer.put("user1", "A");
        cacheContainer.put("user1", "A");
        cacheContainer.put("user2", "B");
        cacheContainer.put("user3", "C");
        cacheContainer.put("user4", "D");
        cacheContainer.list();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cacheContainer.put("user5", "E");
        cacheContainer.put("user6", "F");
        cacheContainer.put("user6", "FF");
        cacheContainer.put("user6", "F");
        cacheContainer.put("user6", "FF");
        cacheContainer.list();
        System.out.println("get user4: " + cacheContainer.get("user4"));
        cacheContainer.list();
        System.out.println("get user5: " + cacheContainer.get("user5"));
        cacheContainer.list();
        cacheContainer.put("user6", "FF");
        cacheContainer.list();
    }

}