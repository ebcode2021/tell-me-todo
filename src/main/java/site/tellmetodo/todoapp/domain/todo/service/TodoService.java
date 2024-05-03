package site.tellmetodo.todoapp.domain.todo.service;

import site.tellmetodo.todoapp.domain.todo.dto.TodoListDto;

import java.util.Date;
import java.util.List;

public interface TodoService {

    List<TodoListDto> getTodoList(Long id, Date date);

}
