package site.tellmetodo.todoapp.domain.todo.dto;

import lombok.*;
import site.tellmetodo.todoapp.domain.todo.entity.Todo;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TodoListDto {

    private Long id;

    private String content;

    private boolean favorite;

    private boolean completed;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    public static TodoListDto toDto(Todo todo) {
        return new TodoListDto(
                todo.getId(),
                todo.getContent(),
                todo.isFavorite(),
                todo.isCompleted(),
                todo.getCreated_at(),
                todo.getUpdated_at()
        );
    }
}
