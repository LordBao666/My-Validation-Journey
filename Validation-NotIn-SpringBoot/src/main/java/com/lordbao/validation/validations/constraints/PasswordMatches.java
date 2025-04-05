package com.lordbao.validation.validations.constraints;


import com.lordbao.validation.validations.constants.CaseMode;
import com.lordbao.validation.validations.validator.CheckCaseValidator;
import com.lordbao.validation.validations.validator.PasswordMatchesValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.lordbao.validation.validations.constraints.PasswordMatches.List;
/**
 * @Author Lord_Bao
 * @Date 2025/4/5 17:24
 * @Version 1.0
 */
@Target({ TYPE,  ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Documented
@Repeatable(List.class)
public @interface PasswordMatches {

    String message() default "{com.lordbao.validator.PasswordMatches.message}";
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };


    @Target({ TYPE,  ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        PasswordMatches[] value();
    }
}
