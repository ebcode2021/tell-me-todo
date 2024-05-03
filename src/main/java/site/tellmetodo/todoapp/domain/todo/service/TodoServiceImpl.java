package site.tellmetodo.todoapp.domain.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.tellmetodo.todoapp.domain.todo.dto.TodoListDto;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    @Override
    public List<TodoListDto> getTodoList(Long id, Date date) {
        return null;
    }
}
