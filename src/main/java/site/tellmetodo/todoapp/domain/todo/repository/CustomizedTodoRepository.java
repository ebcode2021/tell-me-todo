package site.tellmetodo.todoapp.domain.todo.repository;

import site.tellmetodo.todoapp.domain.todo.entity.Todo;

import java.time.LocalDate;
import java.util.List;

public interface CustomizedTodoRepository {

    void deleteTodoListByUserIdAndDate(Long id, LocalDate date);

    void reverseTodoFavorite(Long id);

    void reverseTodoCompleted(Long id);

    void updateTodoContent(Long id, String content);

    List<Todo> findTodoListByUserIdAndDateOrderByCreated(Long id, LocalDate date);

    List<Todo> findTodoListByUserIdAndDateOrderByRecent(Long id, LocalDate date);

    List<Todo> findTodoListByUserIdAndDateOrderByName(Long id, LocalDate date);

    List<Todo> findTodoListByUserIdAndDateOrderByCompleted(Long id, LocalDate date);

    /**
     * @deprecated
     */
    List<Todo> findTodoListByUserIdAndDate(Long id, LocalDate date);
}
