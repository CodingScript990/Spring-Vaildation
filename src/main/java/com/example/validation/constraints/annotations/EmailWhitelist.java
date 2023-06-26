package com.example.validation.constraints.annotations;

import com.example.validation.constraints.EmailWhitelistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // 어노테이션을 어디에 적용할 것인지 (선택)
@Retention(RetentionPolicy.RUNTIME) // 어노테이션이 언제까지 유지될 것인지
@Constraint(validatedBy = EmailWhitelistValidator.class)
public @interface EmailWhitelist {
    // Annotation Element
    String message() default "Email not in whitelist"; // 메세지를 남겨주는 용도
    Class<?>[] groups() default {}; // 유성 검증을 하기 위한 작업
    Class<? extends Payload>[] payload() default {}; // 유효성 검증 실패할때 추가적 설명을 해주는 것
}
