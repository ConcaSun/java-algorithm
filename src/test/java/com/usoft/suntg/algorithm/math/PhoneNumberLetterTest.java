package com.usoft.suntg.algorithm.math;

import junit.framework.TestCase;

import java.util.List;

/**
 * @author suntg
 * @date ${date}
 */
public class PhoneNumberLetterTest extends TestCase {

    public void test1() {
        String digits = "23";
        List<String> letters = PhoneNumberLetter.convert(digits);
        assertEquals("[ad, ae, af, bd, be, bf, cd, ce, cf]", letters.toString());
    }

    public void test2() {
        String digits = "2";
        List<String> letters = PhoneNumberLetter.convert(digits);
        assertEquals("[a, b, c]", letters.toString());
    }

    public void test3() {
        String digits = "29";// abc wxyz
        List<String> letters = PhoneNumberLetter.convert(digits);
        assertEquals("[aw, ax, ay, az, bw, bx, by, bz, cw, cx, cy, cz]", letters.toString());
    }

    public void test4() {
        String digits = "293";// abc wxyz def
        List<String> letters = PhoneNumberLetter.convert(digits);
        assertEquals("[awd, awe, awf, axd, axe, axf, ayd, aye, ayf, azd, aze, azf, bwd, bwe, bwf, bxd, bxe, bxf, byd, bye, byf, bzd, bze, bzf, cwd, cwe, cwf, cxd, cxe, cxf, cyd, cye, cyf, czd, cze, czf]", letters.toString());
    }
}
