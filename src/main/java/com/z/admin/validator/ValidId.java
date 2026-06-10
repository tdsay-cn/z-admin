package com.z.admin.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * @author tdsay
 * @description ID校验注解（不能为空且必须大于0）
 */
@Documented
@Constraint(validatedBy = ValidIdValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidId {

    String message() default "ID不能为空且必须大于0";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
