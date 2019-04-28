package com.usoft.suntg.algorithm.io.utils;

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ConcaSun on 2019/4/28.
 */
public class InputUtil {

    private static final BufferedReader KEYBOARD_INPUT = new BufferedReader(new InputStreamReader(System.in));

    /**
     * 将键盘输入数据转换为String
     * @param prompt
     * @return
     */
    public static String getString(String prompt) {
        String result = null;
        boolean flag = true;
        while (flag) {
            System.out.println(prompt);
            try {
                result = KEYBOARD_INPUT.readLine();
                if (StringUtils.isEmpty(result)) {
                    System.out.println("输入内容错误，不允许为空...");
                } else {
                    flag = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

}
