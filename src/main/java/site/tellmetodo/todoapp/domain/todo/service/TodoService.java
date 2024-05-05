package site.tellmetodo.todoapp.domain.todo.service;

import site.tellmetodo.todoapp.domain.todo.dto.TodoListDto;

import java.time.LocalDate;
import java.util.List;

public interface TodoService {

    List<TodoListDto> getTodoListByUserIdAndLocalDate(Long id, LocalDate date);

    void removeTodoListByDate(Long id, LocalDate date);
}
