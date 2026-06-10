package com.z.admin.validator;

import com.z.admin.util.DataUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author tdsay
 * @description ID校验器
 */
public class ValidIdValidator implements ConstraintValidator<ValidId, Long> {

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return DataUtils.idIsNotNull(id);
    }

}
