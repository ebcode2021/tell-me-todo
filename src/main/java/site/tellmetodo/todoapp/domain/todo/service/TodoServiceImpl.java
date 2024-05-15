package site.tellmetodo.todoapp.domain.todo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.tellmetodo.todoapp.domain.todo.dto.TodoCreateDto;
import site.tellmetodo.todoapp.domain.todo.dto.TodoListDto;
import site.tellmetodo.todoapp.domain.todo.entity.Todo;
import site.tellmetodo.todoapp.domain.todo.entity.TodoSort;
import site.tellmetodo.todoapp.domain.todo.repository.TodoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public List<TodoListDto> getTodoListByUserIdAndLocalDateAndSort(Long id, LocalDate date, TodoSort sort) {
        List<Todo> todoList;

        if (sort == TodoSort.RECENT) {
            todoList = todoRepository.findTodoListByUserIdAndDateOrderByRecent(id, date);
        } else if (sort == TodoSort.NAME) {
            todoList = todoRepository.findTodoListByUserIdAndDateOrderByName(id, date);
        } else if (sort == TodoSort.COMPLETED) {
            todoList = todoRepository.findTodoListByUserIdAndDateOrderByCompleted(id, date);
        } else {
            todoList = todoRepository.findTodoListByUserIdAndDateOrderByCreated(id, date);
        }

        return todoList.stream()
                .map(TodoListDto::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void removeTodoListByDate(Long id, LocalDate date) {
        todoRepository.deleteTodoListByUserIdAndDate(id, date);
    }

    @Override
    public void addTodo(TodoCreateDto todoCreateDto) {
        todoRepository.save(Todo.createTodo(todoCreateDto));
    }

    @Override
    public void editTodoFavorite(Long id) {
        todoRepository.reverseTodoFavorite(id);
    }

    @Override
    public void editTodoCompleted(Long id) {
        todoRepository.reverseTodoCompleted(id);
    }

    @Override
    public void editTodoContent(Long id, String content) {
        todoRepository.updateTodoContent(id, content);
    }


    @Override
    public void removeTodo(Long id) {
        todoRepository.deleteById(id);
    }

    /**
     * @deprecated
     */
    @Override
    public List<TodoListDto> getTodoListByUserIdAndLocalDate(Long id, LocalDate date) {
        List<Todo> todoList = todoRepository.findTodoListByUserIdAndDate(id, date);

        return todoList.stream()
                .map(TodoListDto::toDto)
                .collect(Collectors.toList());
    }

}
