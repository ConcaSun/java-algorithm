package com.usoft.suntg.algorithm.patterns.clock;

import java.util.Iterator;
import java.util.Vector;

/**
 * subject 定义了添加观察者和触发观察者执行操作的方法
 * 触发器继承自这个类，通过添加观察者方法添加观察者，再调用notifyObservers 通知观察者
 *
 * Created by ConcaSun on 2019/4/23.
 */
public class Subject {

    private Vector<Observer> observers = new Vector<>();

    public void notifyObservers(int hours, int minutes, int seconds) {
        Iterator<Observer> iterator = observers.iterator();
        while (iterator.hasNext()) {
            Observer observer = iterator.next();
            observer.update(hours, minutes, seconds);
        }
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
}
