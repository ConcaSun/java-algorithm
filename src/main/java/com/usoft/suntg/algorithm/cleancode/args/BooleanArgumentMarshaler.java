package com.usoft.suntg.algorithm.cleancode.args;

import java.util.Iterator;

/**
 * @author suntg
 * @date 2019-3-7 11:07:03
 */
public class BooleanArgumentMarshaler implements ArgumentMarshaler{

    private boolean booleanValue;

    @Override
    public void set(String currentArgument) throws ArgsException {
        if (!"fale".equals(currentArgument)) {
            booleanValue = true;
        }
    }

    public boolean getValue() {
        return booleanValue;
    }

    public static boolean getValue(ArgumentMarshaler marshaler) {
        if (marshaler != null && marshaler instanceof BooleanArgumentMarshaler) {
            return ((BooleanArgumentMarshaler) marshaler).booleanValue;
        }
        return false;
    }

}
