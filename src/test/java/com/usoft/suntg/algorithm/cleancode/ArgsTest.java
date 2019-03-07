package com.usoft.suntg.algorithm.cleancode;

import com.usoft.suntg.algorithm.cleancode.args.Args;
import junit.framework.TestCase;

/**
 * @author suntg
 * @date ${date}
 */
public class ArgsTest extends TestCase {

    public void testGetBoolean() {
        Args args = new Args("x", new String[] {"true"});
        assertTrue(args.getBoolean('x'));
    }

}
