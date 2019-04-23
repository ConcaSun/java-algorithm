package com.usoft.suntg.algorithm.patterns;

/**
 * 模板方法模式
 * 抽象计算器
 * Created by ConcaSun on 2019/4/23.
 */
public abstract class AbstractCalculator {

    /**
     * 模板方法，确定实现的步骤
     * @param str
     * @param opt
     * @return
     */
    public int getResult(String str, String opt) {
        return calculate(convertToIntArray(str, opt));
    }

    private int[] convertToIntArray(String str, String opt) {
        String[] strArray = str.split(opt);
        int[] result = new int[strArray.length];
        for (int i = 0; i < strArray.length; i ++) {
            result[i] = Integer.parseInt(strArray[i]);
        }
        return result;
    }

    /**
     * 抽象方法，由子类实现
     * @param args
     * @return
     */
    public abstract int calculate(int[] args);
}
