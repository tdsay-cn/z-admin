package com.z.admin.validator;

import com.z.admin.util.DataUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author tdsay
 * @description 手机号校验器
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    private static final String PHONE_REGEX = "^1[3-9]\\d{9}$";

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {
        if (DataUtils.isEmpty(phone)) {
            return true;
        }
        return phone.matches(PHONE_REGEX);
    }

}
