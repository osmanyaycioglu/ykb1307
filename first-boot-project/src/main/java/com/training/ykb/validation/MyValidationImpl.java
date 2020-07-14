package com.training.ykb.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyValidationImpl implements ConstraintValidator<MyValidation, String> {

    private MyValidation a;

    @Override
    public void initialize(final MyValidation a) {
        this.a = a;
    }

    @Override
    public boolean isValid(final String valueParam,
                           final ConstraintValidatorContext contextParam) {
        String endLoc = this.a.end();
        if ((endLoc != null) && !endLoc.isEmpty()) {
            if (!valueParam.endsWith(endLoc)) {
                return false;
            }
        }

        return valueParam.startsWith(this.a.start());
    }

}
