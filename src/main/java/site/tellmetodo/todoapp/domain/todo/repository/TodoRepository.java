package site.tellmetodo.todoapp.domain.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.tellmetodo.todoapp.domain.todo.dto.TodoListDto;
import site.tellmetodo.todoapp.domain.todo.entity.Todo;

import java.util.Date;
import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>, CustomizedTodoRepository {

}
