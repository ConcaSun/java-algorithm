package com.usoft.suntg.algorithm.patterns.event;

/**
 * Created by ConcaSun on 2019/5/16.
 */
public interface EventListener<T extends Event> {

    public void listen(T t);

}
