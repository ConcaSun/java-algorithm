package com.usoft.suntg.algorithm.patterns.cache;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * LFU 最少被使用算法 缓存容器
 * Created by ConcaSun on 2019/5/26.
 */
public class LFUCacheContainer implements CacheContainer {

    /**
     * 容量
     */
    private int capacity = 5;
    /**
     * 计数器
     */
    private int count;

    private Map<String, HitRate> cache = new HashMap<>();

    public LFUCacheContainer(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void put(String key, Object value) {
        HitRate hitRate = cache.get(key);
        if (hitRate == null) {
            if (count >= capacity) {
                popTail();
                count --;
            }

            cache.put(key, new HitRate(key, value));
            count ++;
        } else {
            hitRate.updateValue(value);
        }
    }

    private void popTail() {
        HitRate tail = Collections.min(cache.values());
        cache.remove(tail.getKey());
    }

    @Override
    public Object get(String key) {
        HitRate hitRate = cache.get(key);
        if (hitRate != null) {
            hitRate.hit();
            return  hitRate.getValue();
        }
        return null;
    }

    public void list() {
        System.out.println("vvvv cache start vvvv");
        cache.values().stream().forEach(t -> {
            System.out.println(t);
        });
        System.out.println("^^^^ cache end ^^^^");
    }



    private class HitRate implements Comparable<HitRate> {

        private String key;
        private Object value;
        private int hit;
        private long lastTime;

        public HitRate(String key, Object value) {
            this.key = key;
            this.value = value;
            this.hit = 1;
            this.lastTime = System.currentTimeMillis();
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public int getHit() {
            return hit;
        }

        public void setHit(int hit) {
            this.hit = hit;
        }

        public long getLastTime() {
            return lastTime;
        }

        public void setLastTime(long lastTime) {
            this.lastTime = lastTime;
        }

        /**
         * 被读命中
         */
        public void hit() {
            this.hit ++;
            this.lastTime = System.currentTimeMillis();
        }

        /**
         * 修改value内容
         * @param value
         */
        public void updateValue(Object value) {
            this.value = value;
            hit();
        }

        @Override
        public int compareTo(HitRate o) {
            int compare = Integer.compare(this.hit, o.getHit());
            if (compare == 0) {
                compare = Long.compare(this.lastTime, o.getLastTime());
            }
            return compare;
        }

        @Override
        public String toString() {
            return "HitRate{" +
                    "key='" + key + '\'' +
                    ", value=" + value +
                    ", hit=" + hit +
                    ", lastTime=" + lastTime +
                    '}';
        }
    }
}
