package com.example.validation.constraints.annotations;

import com.example.validation.constraints.BlackListValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BlackListValidator.class)
public @interface BlackList {
    String message() default "username in blacklist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    // Element Add
    String[] blackList() default {};
}
