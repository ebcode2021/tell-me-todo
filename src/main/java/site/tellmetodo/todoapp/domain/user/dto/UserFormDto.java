package site.tellmetodo.todoapp.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import site.tellmetodo.todoapp.domain.user.entity.User;

/**
 * @brief 회원 가입 dto
 * @details Bean Validation 을 통한 값 검증
 */
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class UserFormDto {

    @NotBlank
    @Length(min = 6, max = 20)
    @Pattern(regexp = "^[a-zA-Z0-9_]*$")
    private String username;

    @NotBlank
    @Length(min = 8, max = 20)
    @Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*]*$")
    private String password;

    @NotBlank
    @Pattern(regexp = "^[ㄱ-ㅎㅏ-ㅣ가-힣a-z0-9\\s]*$")
    private String nickname;

    @Email
    private String email;

    public User toEntity() {
        return User.createUser(this);
//        return User.builder()
//                .username(username)
//                .password(password)
//                .nickname(nickname)
//                .email(email)
//                .build();
    }
}
