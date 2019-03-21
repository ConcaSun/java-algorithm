package com.usoft.suntg.algorithm.cleancode.args;

import java.util.Iterator;

/**
 * @author suntg
 * @date ${date}
 */
public class IntegerArgumentMarshaler implements ArgumentMarshaler {
    private int intValue;

    /**
     * @param currentArgument
     * @throws ArgsException
     */
    @Override
    public void set(String currentArgument) throws ArgsException {
        try {
            intValue = Integer.parseInt(currentArgument);
        } catch (Exception e) {
            throw new ArgsException("Invalid int value: " + intValue);
        }

    }

    public int getValue() {
        return intValue;
    }

    public static int getValue(ArgumentMarshaler marshaler) {
        if (marshaler != null && marshaler instanceof IntegerArgumentMarshaler) {
            return ((IntegerArgumentMarshaler) marshaler).intValue;
        }
        return 0;
    }
}
