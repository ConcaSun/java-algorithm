package com.usoft.suntg.algorithm.cleancode.args;

import java.util.Map;

/**
 * @author suntg
 * @date ${date}
 */
public class Args {

    private Map<Character, ArgumentMarshaler> marshalers;

    public Args(String schema, String [] args) throws ArgsException {
        parseSchema(schema);
        parseArgumentStrings(args);
    }

    private void parseSchema(String schema) {
        for (String element : schema.split(",")) {
            Character elementId = getElementIdCharacter(element);
            ArgumentMarshaler marshaler = getMarshalerByElement(element);
            marshalers.put(elementId, marshaler);
        }
    }

    private Character getElementIdCharacter(String element) {
        char elementId = element.charAt(0);
        validateElementId(elementId);
        return elementId;
    }

    private void validateElementId(char elementId) {
        if (!Character.isLetter(elementId)) {
            throw new ArgsException("");
        }
    }

    private ArgumentMarshaler getMarshalerByElement(String element) {
        String elementTail = element.substring(1);
        if (elementTail.length() == 0) {
            return new BooleanArgumentMarshaler();
        } else if (elementTail.equals("*")) {
            return new StringArgumentMarshaler();
        } else if (elementTail.equals("#")) {
            return new IntegerArgumentMarshaler();
        } else if (elementTail.equals("##")) {
            return new DoubleIntegerArgumentMarshaler();
        } else {
            throw new ArgsException("");
        }
    }

    private void parseArgumentStrings(String[] args) {
    }


    public boolean getBoolean(char arg) {
        return false;
    }

    public String getString(char arg) {
        return null;
    }

    public int getInt(char arg) {
        return 0;
    }

    public double getDouble(char arg) {
        return 0;
    }

}
