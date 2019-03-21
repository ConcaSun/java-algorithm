package com.usoft.suntg.algorithm.cleancode.args;

import java.util.Iterator;

/**
 * @author suntg
 * @date ${date}
 */
public class DoubleArgumentMarshaler implements ArgumentMarshaler {
    private double doubleValue;

    /**
     * @param currentArgument
     * @throws ArgsException
     */
    @Override
    public void set(String currentArgument) throws ArgsException {
        try {
            doubleValue = Double.parseDouble(currentArgument);
        } catch (Exception e) {
            throw new ArgsException("Invalid double value: " + currentArgument);
        }
    }

    public double getValue() {
        return doubleValue;
    }

    public static double getValue(ArgumentMarshaler marshaler) {
        if (marshaler != null && marshaler instanceof DoubleArgumentMarshaler) {
            return ((DoubleArgumentMarshaler) marshaler).doubleValue;
        }
        return 0;
    }
}
