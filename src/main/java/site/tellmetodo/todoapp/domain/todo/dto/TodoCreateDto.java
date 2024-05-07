package site.tellmetodo.todoapp.domain.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import site.tellmetodo.todoapp.domain.user.entity.User;

@Getter @Setter
@AllArgsConstructor
public class TodoCreateDto {

    private User user;

    private String content;

}
