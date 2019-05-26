package com.usoft.suntg.algorithm.pattern;

import com.usoft.suntg.algorithm.patterns.aop.*;
import junit.framework.TestCase;

import java.lang.reflect.Proxy;

/**
 * Created by ConcaSun on 2019/5/18.
 */
public class UserServiceTest extends TestCase {

    public void testStaticUserServiceProxy() {
        UserService userService = new StaticUserServiceLogProxy(new UserServiceImpl());
        userService.addUser(2321L);
    }

    public void testLogMethodProxy() {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        EnterpriseServiceImpl enterpriseServiceImpl = new EnterpriseServiceImpl();

        UserService userService = (UserService) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                userServiceImpl.getClass().getInterfaces(), new LogMethodProxy(userServiceImpl));
        EnterpriseService enterpriseService = (EnterpriseService) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{EnterpriseService.class}, new LogMethodProxy(enterpriseServiceImpl));

        userService.addUser(123L);
        enterpriseService.addEnterprise(54543L);
    }

}
