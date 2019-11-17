package com.usoft.suntg.algorithm.patterns.aop;

/**
 * 静态代理，针对不同的接口创建代理类
 * Created by ConcaSun on 2019/5/18.
 */
public class StaticUserServiceLogProxy implements UserService {

    private UserService userService;

    public StaticUserServiceLogProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void addUser(Long id) {
        logMethodStart("addUser");
        userService.addUser(id);
        logMethodEnd("addUser");
    }

    private void logMethodStart(String methodName) {
        System.out.println("[StaticUserServiceLogProxy] method start: " + methodName);
    }

    private void logMethodEnd(String methodName) {
        System.out.println("[StaticUserServiceLogProxy] method end: " + methodName);
    }
}
