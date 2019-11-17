package com.usoft.suntg.algorithm.patterns.templatemethod;

/**
 * Created by ConcaSun on 2019/11/17.
 */
public class ChangeValidateRule {
    private String changeOperateType;
    private String maxStatus;
    private Boolean valid;
    private String message;

    public String getChangeOperateType() {
        return changeOperateType;
    }

    public void setChangeOperateType(String changeOperateType) {
        this.changeOperateType = changeOperateType;
    }

    public String getMaxStatus() {
        return maxStatus;
    }

    public void setMaxStatus(String maxStatus) {
        this.maxStatus = maxStatus;
    }

    public Boolean getValid() {
        return valid == null || valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
