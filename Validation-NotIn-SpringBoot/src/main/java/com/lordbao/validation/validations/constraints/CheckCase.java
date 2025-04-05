package com.lordbao.validation.validations.constraints;


import com.lordbao.validation.validations.constants.CaseMode;
import com.lordbao.validation.validations.validator.CheckCaseValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.lordbao.validation.validations.constraints.CheckCase.List;

/**
 * @Author Lord_Bao
 * @Date 2025/4/4 21:15
 * @Version 1.0
 */
@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = CheckCaseValidator.class)
@Documented
@Repeatable(List.class)
public @interface CheckCase {

//    String message() default "case must be {value}";
    String message() default "{com.lordbao.validator.CheckCase.message}";
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    CaseMode value();

    @Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        CheckCase[] value();
    }
}
