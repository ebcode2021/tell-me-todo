package site.tellmetodo.todoapp.domain.todo.repository;

import site.tellmetodo.todoapp.domain.todo.dto.TodoListDto;
import site.tellmetodo.todoapp.domain.todo.entity.Todo;

import java.time.LocalDate;
import java.util.List;

public interface CustomizedTodoRepository {

    List<Todo> findTodoListByUserIdAndDate(Long id, LocalDate date);

    void deleteTodoListByUserIdAndDate(Long id, LocalDate date);
}
