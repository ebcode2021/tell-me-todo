package site.tellmetodo.todoapp.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class UserDto {
    private Long id;

    private String username;

    private String password;
}
