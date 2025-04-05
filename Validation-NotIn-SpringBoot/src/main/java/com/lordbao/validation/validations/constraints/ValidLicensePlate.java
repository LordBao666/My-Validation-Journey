package com.lordbao.validation.validations.constraints;

import com.lordbao.validation.validations.constants.CaseMode;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@NotNull
@Size(min = 2, max = 14)
@CheckCase(CaseMode.UPPER)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = { })
@Documented
@ReportAsSingleViolation
public @interface ValidLicensePlate {

    String message() default "license plate is invalid";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}