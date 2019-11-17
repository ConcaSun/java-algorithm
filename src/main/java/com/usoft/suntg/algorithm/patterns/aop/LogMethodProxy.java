package com.usoft.suntg.algorithm.patterns.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理，专门为
 * Created by ConcaSun on 2019/5/18.
 */
public class LogMethodProxy implements InvocationHandler {

    private Object target;

    public LogMethodProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logMethodStart(method.getName());
        method.invoke(target, args);
        logMethodEnd(method.getName());
        return null;
    }

    private void logMethodStart(String methodName) {
        System.out.println("[LogMethodProxy] method start: " + methodName);
    }

    private void logMethodEnd(String methodName) {
        System.out.println("[LogMethodProxy] method end: " + methodName);
    }
}
