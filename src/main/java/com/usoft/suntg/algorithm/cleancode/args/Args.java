package com.usoft.suntg.algorithm.cleancode.args;

import java.util.HashMap;
import java.util.Map;

/**
 * @author suntg
 * @date ${date}
 */
public class Args {

    private Map<Character, ArgumentMarshaler> marshalers = new HashMap<>();

    public Args(String schema, String args) throws ArgsException {
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
            return new DoubleArgumentMarshaler();
        } else {
            throw new ArgsException("");
        }
    }

    private void parseArgumentStrings(String args) {
        String[] strArray = args.split(" ");
        String elementId = "";
        String elementValue = "";
        for (String str : strArray) {
            if (str.startsWith("-")) {
                elementId = str;
                setElementValue(elementId, elementValue);
            } else if (str.length() > 0) {
                elementValue += str;
                elementValue += " ";
            }
        }
    }

    private void setElementValue(String elementId, String elementValue) {
        ArgumentMarshaler marshaler = marshalers.get(elementId.substring(1));
        if (marshaler == null) {
            throw new ArgsException("Unexpected argument: " + elementId);
        } else {
            marshaler.set(elementValue.trim());
        }
    }


    public boolean getBoolean(char arg) {
        return BooleanArgumentMarshaler.getValue(marshalers.get(arg));
    }

    public String getString(char arg) {
        return StringArgumentMarshaler.getValue(marshalers.get(arg));
    }

    public int getInt(char arg) {
        return IntegerArgumentMarshaler.getValue(marshalers.get(arg));
    }

    public double getDouble(char arg) {
        return DoubleArgumentMarshaler.getValue(marshalers.get(arg));
    }

}
