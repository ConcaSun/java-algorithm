package com.usoft.suntg.algorithm.patterns.aop;

/**
 * 静态代理，针对不同的接口创建代理类
 * Created by ConcaSun on 2019/5/18.
 */
public class StaticEnterpriseServiceLogProxy implements EnterpriseService {

    private EnterpriseService enterpriseService;

    public StaticEnterpriseServiceLogProxy(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    @Override
    public void addEnterprise(Long id) {
        logMethodStart("addEnterprise");
        enterpriseService.addEnterprise(id);
        logMethodEnd("addEnterprise");
    }

    private void logMethodStart(String methodName) {
        System.out.println("[StaticUserServiceLogProxy] method start: " + methodName);
    }

    private void logMethodEnd(String methodName) {
        System.out.println("[StaticUserServiceLogProxy] method end: " + methodName);
    }
}
