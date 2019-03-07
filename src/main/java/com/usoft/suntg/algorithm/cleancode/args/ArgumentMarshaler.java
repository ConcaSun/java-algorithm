package com.usoft.suntg.algorithm.cleancode.args;

import java.util.Iterator;

/**
 * @author suntg
 * @date 2019-3-7 11:03:16
 */
public interface ArgumentMarshaler {

    /**
     *
     * @param currentArgument
     * @throws ArgsException
     */
    public void set(Iterator<String> currentArgument) throws ArgsException;

}
