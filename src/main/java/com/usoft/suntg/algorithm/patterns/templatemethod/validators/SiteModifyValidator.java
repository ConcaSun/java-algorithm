package com.usoft.suntg.algorithm.patterns.templatemethod.validators;

import com.usoft.suntg.algorithm.patterns.templatemethod.AbstractChangeValidator;

/**
 * Created by ConcaSun on 2019/11/17.
 */
public class SiteModifyValidator extends AbstractChangeValidator {

    private static final String SITE_MODIFY = "site_modify";

    private Long siteId;
    private Long siteGuid;

    public SiteModifyValidator(Long siteGuid) {
        this.siteGuid = siteGuid;
    }

    @Override
    protected String getMaxStatus() {
        // TODO 根据siteGuid 获取最大状态
        return null;
    }

    @Override
    protected String getOperateType() {
        return SITE_MODIFY;
    }
}
