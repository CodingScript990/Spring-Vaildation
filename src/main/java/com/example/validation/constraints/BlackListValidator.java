package com.example.validation.constraints;

import com.example.validation.constraints.annotations.BlackList;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.HashSet;
import java.util.Set;

public class BlackListValidator implements ConstraintValidator<BlackList, String> {

    // Member Field
    private Set<String> blackList;

    // initialize method
    @Override
    public void initialize(BlackList constraintAnnotation) {
        // 호출이 되는 시점으로 생성 여부
        blackList = new HashSet<>();

        for (String target : constraintAnnotation.blackList()) {
            blackList.add(target);
        }
    }

    // isValid method
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 검증 할지 말지 여부 => this.blackList 안에 value 가 있으면 실패
        return !this.blackList.contains(value);
    }
}
