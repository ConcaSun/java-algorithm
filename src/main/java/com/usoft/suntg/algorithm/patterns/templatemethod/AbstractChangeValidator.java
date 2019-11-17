package com.usoft.suntg.algorithm.patterns.templatemethod;

/**
 * Created by ConcaSun on 2019/11/17.
 */
public abstract class AbstractChangeValidator {

    public ValidateResult validate() {
        String operateType = getOperateType();
        String maxStatus = getMaxStatus();
        ChangeValidateRule changeValidateRule = getChangeValidateRule(operateType, maxStatus);
        if (changeValidateRule == null) {
            return ValidateResult.success();
        }
        if (changeValidateRule.getValid()) {
            return ValidateResult.success();
        }
        return ValidateResult.error(changeValidateRule.getMessage());
    }

    protected abstract String getMaxStatus();

    protected abstract String getOperateType();

    protected ChangeValidateRule getChangeValidateRule(String operateType, String maxStatus) {
        return new ChangeValidateRule();
    }
}
