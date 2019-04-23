package com.usoft.suntg.algorithm.pattern;

import com.usoft.suntg.algorithm.patterns.clock.MockTimeSink;
import com.usoft.suntg.algorithm.patterns.clock.MockTimeSource;
import junit.framework.TestCase;

/**
 * Created by ConcaSun on 2019/4/23.
 */
public class ClockTest extends TestCase {

    public void test() {
        MockTimeSource source = new MockTimeSource();
        MockTimeSink sink = new MockTimeSink();
        source.registerObserver(sink);

        source.notifyObservers(3, 4, 5);
        assertEqualsSink(sink, 3, 4, 5);

        source.notifyObservers(6, 7, 8);
        assertEqualsSink(sink, 6, 7, 8);
    }

    private void assertEqualsSink(MockTimeSink sink, int hours, int minutes, int seconds) {
        assertEquals(hours, sink.getHours());
        assertEquals(minutes, sink.getMinutes());
        assertEquals(seconds, sink.getSeconds());
    }

}
