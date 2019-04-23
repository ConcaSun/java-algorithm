package com.usoft.suntg.algorithm.patterns.clock;

import java.util.Iterator;
import java.util.Vector;

/**
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
