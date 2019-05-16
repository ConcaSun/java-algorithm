package com.usoft.suntg.algorithm.pattern;

import com.usoft.suntg.algorithm.patterns.event.*;
import junit.framework.TestCase;

/**
 * Created by ConcaSun on 2019/5/16.
 */
public class EventTest extends TestCase {

    public void testGetEventName() {
        EventListener eventListener = new ScreenGameStartListener();
        String eventName = PublishEventUtil.getEventClassName(eventListener);
        assertEquals("com.usoft.suntg.algorithm.patterns.event.GameStartEvent", eventName);
    }

    public void testGetEventClassName() {
        Event event = new GameStartEvent("勇士 vs 火箭");
        String eventName = PublishEventUtil.getEventClassName(event);
        assertEquals("com.usoft.suntg.algorithm.patterns.event.GameStartEvent", eventName);
    }

    /**
     * idea对junit 测试多线程程序，主线程完成后会自动停止，不会等待其他线程继续执行，问题还没处理
     */
    public void testPublishEvent() {
        PublishEventUtil.addListener(new ScreenGameStartListener());
        PublishEventUtil.addListener(new LightGameStartListener());
        PublishEventUtil.publish(new GameStartEvent("勇士 vs 火箭"));
    }

}
