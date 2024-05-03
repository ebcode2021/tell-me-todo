package site.tellmetodo.todoapp.domain.todo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TodoListDto {

    private Long id;

    private Long userId;

    private String content;

    private boolean favorite;

    private boolean completed;
}
