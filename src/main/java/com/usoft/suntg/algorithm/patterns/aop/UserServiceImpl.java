package com.usoft.suntg.algorithm.patterns.aop;

/**
 * Created by ConcaSun on 2019/5/18.
 */
public class UserServiceImpl implements UserService {
    @Override
    public void addUser(Long id) {
        System.out.println("[UserServiceImpl] 添加用户: " + id);
    }
}
