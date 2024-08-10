package slo.slo_spring_server.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import slo.slo_spring_server.domain.user.Gender;
import slo.slo_spring_server.domain.user.Role;
import slo.slo_spring_server.domain.user.Status;
import slo.slo_spring_server.domain.user.User;
import slo.slo_spring_server.exception.ValidEnum;

public class UserDTO {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {

        private Long id;

        @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{4,20}$", message = "아이디는 특수문자를 제외한 4~20자리여야 합니다.")
        @NotBlank(message = "아이디는 필수 입력 값입니다.")
        private String username;

        @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
        private String password;

        @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-zA-Z0-9-_]{2,10}$", message = "닉네임은 특수문자를 제외한 2~10자리여야 합니다.")
        @NotBlank(message = "닉네임은 필수 입력 값입니다.")
        private String nickname;

        @Pattern(regexp = "^(?:\\w+\\.?)*\\w+@(?:\\w+\\.)+\\w+$", message = "이메일 형식이 올바르지 않습니다.")
        @NotBlank(message = "이메일은 필수 입력 값입니다.")
        private String email;

        @ValidEnum(enumClass = Role.class)
        private Role role;
        @ValidEnum(enumClass = Gender.class)
        private Gender gender;
        @ValidEnum(enumClass = Status.class)
        private Status status;
        private int weight;
        private int height;
        private int age;

        public User toEntity() {
            return User.builder()
                    .id(id)
                    .username(username)
                    .password(password)
                    .nickname(nickname)
                    .email(email)
                    .role(Role.USER)
                    .gender(gender)
                    .status(Status.ACT)
                    .weight(weight)
                    .height(height)
                    .age(age)
                    .build();
        }
    }
}
