package com.usoft.suntg.algorithm.patterns.event;

import org.springframework.util.CollectionUtils;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ConcaSun on 2019/5/16.
 */
public class PublishEventUtil {

    /**
     * 事件对应的监听器容器
     */
    private static Map<String, Set<EventListener>> listenersMap = new HashMap<>();

    /**
     * 手动添加监听器，会自动对应上自己监听的事件
     * Spring 中应该会在容器初始化的时候进行扫描配置的监听器，并加到容器中
     * @param eventListener
     */
    public static void addListener(EventListener eventListener) {
        String eventName = getEventClassName(eventListener);
        Set<EventListener> listeners = listenersMap.get(eventName);
        if (CollectionUtils.isEmpty(listeners)) {
            listeners = new HashSet<>();
        }
        listeners.add(eventListener);
        listenersMap.put(eventName, listeners);
    }


    /**
     * 根据监听器获取监听的事件的类名
     * @param eventListener
     * @return
     */
    public static String getEventClassName(EventListener eventListener) {
        return ((ParameterizedType) eventListener.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0].getTypeName();
    }

    /**
     * 获取事件的类名
     * @param event
     * @return
     */
    public static String getEventClassName(Event event) {
        return event.getClass().getCanonicalName();
    }

    /**
     * 发布一个事件，事件对应的监听器会自定触发执行
     * @param event
     */
    public static void publish(Event event) {
        Set<EventListener> eventListeners = listenersMap.get(getEventClassName(event));
        if (!CollectionUtils.isEmpty(eventListeners)) {
            // 采用多线程执行，不阻塞主线程
            ExecutorService executorService = Executors.newCachedThreadPool();
            for (EventListener eventListener : eventListeners) {
                executorService.execute(() -> {
                    eventListener.listen(event);
                });
            }
            executorService.shutdown();
        }
    }

}
