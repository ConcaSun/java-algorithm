package com.usoft.suntg.algorithm.patterns.aop;

/**
 * Created by ConcaSun on 2019/5/18.
 */
public class EnterpriseServiceImpl implements EnterpriseService {

    @Override
    public void addEnterprise(Long id) {
        System.out.println("[EnterpriseServiceImpl] 添加企业: " + id);
    }
}
