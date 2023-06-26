package com.example.validation.controller;

import com.example.validation.dto.UserDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class UserController {
    @PostMapping("/users")
    // Map 을 기준으로 사용함
    public ResponseEntity<Map<String, String>> addUser(
            @Valid @RequestBody UserDto dto // @Valid : UserDto 가 우리가 정의한 요구사항을 지키고 있는지 유효성 검사함
    ) {
        // output result check
        log.info(dto.toString());
        // Map 형태의 String type 을 참조받는 response reference value
        Map<String, String> response = new HashMap<>();
        // successful 하면 message(key) : success!(value) 로 보여줘라
        response.put("message", "success!");

        // response 값을 반환해줘라!
        return ResponseEntity.ok(response);
    }

    // handleValidationException method =>  예외처리
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) // 상태코드 => BAD_REQUEST
    public Map<String, String> handleValidationException(MethodArgumentNotValidException exception) {
        // error 의 값만큼 담아줌
        Map<String, String> errors =  new HashMap<>();

        // 반복문으로 error message 를 보여줌
        for (FieldError error: exception.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        // error 의 값을 반환함
        return errors;
    }
}
