package com.cognizant.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = AccountNumberValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AccountNumberConstraint {
    String message() default "Account number is not valid";
    int min() default 5;
    int max() default 8;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
