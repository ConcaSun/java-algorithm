package com.usoft.suntg.algorithm.cleancode;

import com.usoft.suntg.algorithm.cleancode.args.Args;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author suntg
 * @date ${date}
 */
public class ArgsTest extends TestCase {

    public void testForIterator() {
        Integer[] intArray = new Integer[] {1,2,3,4,5,6,7,8,9};
        System.out.println(intArray.length);
        for (Iterator iterator = Arrays.asList(intArray).iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
            if (iterator.hasNext()) {
                previous(iterator);
            }
        }
    }

    private void previous (Iterator iterator) {
        iterator.next();
    }

    public void testGetBoolean() {
        Args args = new Args("x", "-x");
        assertTrue(args.getBoolean('x'));
    }

}
