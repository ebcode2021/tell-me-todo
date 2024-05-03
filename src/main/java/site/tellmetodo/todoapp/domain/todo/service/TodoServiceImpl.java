package site.tellmetodo.todoapp.domain.todo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.tellmetodo.todoapp.domain.todo.dto.TodoListDto;
import site.tellmetodo.todoapp.domain.todo.entity.Todo;
import site.tellmetodo.todoapp.domain.todo.repository.TodoRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

    @Override
    public List<TodoListDto> getTodoListByUserIdAndLocalDate(Long id, LocalDate date) {
        List<Todo> todoList = todoRepository.findTodoListByUserIdAndDate(id, date);

        return todoList.stream()
                .map(TodoListDto::toDto)
                .collect(Collectors.toList());
    }
}
