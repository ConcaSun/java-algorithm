package com.usoft.suntg.algorithm.patterns.templatemethod;

/**
 * Created by ConcaSun on 2019/11/17.
 */
public class ValidateResult {
    private boolean valid;
    private String message;

    public static ValidateResult success() {
        ValidateResult validateResult = new ValidateResult();
        validateResult.valid = true;
        return validateResult;
    }

    public static ValidateResult error(String message) {
        ValidateResult validateResult = new ValidateResult();
        validateResult.valid = false;
        validateResult.message = message;
        return validateResult;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
