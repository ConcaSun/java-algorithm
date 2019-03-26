package com.usoft.suntg.algorithm.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author suntg
 * @date ${date}
 */
public class PhoneNumberLetter {

    private static String[] LETTER_LIST = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> convert(String digits) {
        List<String> letters = new ArrayList<>();
        String[] strs = new String[digits.length()];
        for (int i = 0; i < digits.length(); i ++) {
            char c = digits.charAt(i);
            strs[i] = LETTER_LIST[Integer.valueOf(String.valueOf(c))];
        }
        combine(letters, strs);
        return letters;
    }

    private static void combine(List<String> result, String... strs) {
        if (strs.length > 1) {
            String first = strs[0];
            for (char c : first.toCharArray()) {
                String sb = "" + c;
                combine(result, sb, Arrays.copyOfRange(strs, 1, strs.length));
            }
        } else {
            String first = strs[0];
            for (char c : first.toCharArray()) {
                result.add(String.valueOf(c));
            }
        }
    }

    private static void combine(List<String> result, String sb, String... strs) {
        if (strs.length > 1) {
            String first = strs[0];
            for (char c : first.toCharArray()) {
                combine(result, sb + c, Arrays.copyOfRange(strs, 1, strs.length));
            }
        } else {
            String first = strs[0];
            for (char c : first.toCharArray()) {
                result.add(sb + c);
            }
        }
    }
}
