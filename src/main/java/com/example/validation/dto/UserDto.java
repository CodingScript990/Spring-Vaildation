package com.example.validation.dto;

import com.example.validation.constraints.annotations.BlackList;
import com.example.validation.constraints.annotations.EmailWhitelist;
import com.example.validation.constraints.annotations.Phone010;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {
    // Member Field

    private Long id;

    @NotBlank(message = "값이 비어있습니다. 값을 입력해주세요.") // @NotBlank : 비어있지 않다는 의미
    @Size(min = 8, message = "최소 8글자여야 합니다.") // 최소 8자리가 충족해야함!
    @BlackList(blackList = {"malware.good", "trojan.jjang"})
    private String username;
    @Email(message = "이메일의 형식을 맞게 입력해주세요.") // @Email : 형식이 email 이여야함
    @EmailWhitelist // gmail, naver 가 맞는지 검증
    private String email;
    @NotNull // @NotNull : Null 값이 아니어야 한다고 명시하는 것
    @Phone010 // 010 으로 시작하는 번호 형식인지 검증
    private String phone;

    @NotNull // null 값이 아니어야 하며
    @Min(value = 14, message = "14세 미만은 부모님의 동의가 필요합니다.") // 최소값이 설정한 숫자 이상되야 함을 명시함
    private Integer age;

    @Future(message = "미래의 시간이어야 합니다.") // 현재말고 미래부터, 즉, 내일시간만 명시!
    private LocalDate validUtil;

    @NotNull // Null 값이 아닌지만 검증함
    private String notNullString;
    @NotEmpty // 길이가 0이 아닌지만 검증함
    private String notEmptyString;
    @NotBlank // 공백 문자로만 이루어지지 않았는지 검증함
    private String notBlankString;
}
