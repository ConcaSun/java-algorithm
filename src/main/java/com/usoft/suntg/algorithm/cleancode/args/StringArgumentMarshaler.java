package com.usoft.suntg.algorithm.cleancode.args;

import java.util.Iterator;

/**
 * @author suntg
 * @date ${date}
 */
public class StringArgumentMarshaler implements ArgumentMarshaler {
    private String stringValue;

    /**
     * @param currentArgument
     * @throws ArgsException
     */
    @Override
    public void set(String currentArgument) throws ArgsException {
        stringValue = currentArgument;
    }

    public String getValue() {
        return stringValue;
    }

    public static String getValue(ArgumentMarshaler marshaler) {
        if (marshaler != null && marshaler instanceof StringArgumentMarshaler) {
            return ((StringArgumentMarshaler) marshaler).stringValue;
        }
        return "";
    }
}
