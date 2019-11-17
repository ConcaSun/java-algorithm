package com.usoft.suntg.algorithm.pattern.validators;

import com.usoft.suntg.algorithm.patterns.templatemethod.ValidateResult;
import com.usoft.suntg.algorithm.patterns.templatemethod.validators.SiteModifyValidator;
import junit.framework.TestCase;

/**
 * Created by ConcaSun on 2019/11/17.
 */
public class SiteModifyValidatorTest extends TestCase {

    public void testValid() {
        Long guid = 23221721L;
        SiteModifyValidator siteModifyValidator = new SiteModifyValidator(guid);
        ValidateResult validateResult = siteModifyValidator.validate();
        if (!validateResult.isValid()) {
            throw new RuntimeException(validateResult.getMessage());
        }
    }

}
