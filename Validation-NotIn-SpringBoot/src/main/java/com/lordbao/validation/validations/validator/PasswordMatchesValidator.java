package com.lordbao.validation.validations.validator;


import com.lordbao.validation.domain.dto.RequestUser;
import com.lordbao.validation.validations.constraints.PasswordMatches;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

/**
 * @Author Lord_Bao
 * @Date 2025/4/5 17:26
 * @Version 1.0
 */
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, RequestUser> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(RequestUser requestUser, ConstraintValidatorContext context) {

        return Objects.equals(requestUser.getPassword(),requestUser.getCheckPassword());
    }
}
