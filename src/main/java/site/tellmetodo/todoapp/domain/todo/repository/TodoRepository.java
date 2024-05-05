package site.tellmetodo.todoapp.domain.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import site.tellmetodo.todoapp.domain.todo.entity.Todo;


@Repository
@Transactional
public interface TodoRepository extends JpaRepository<Todo, Long>, CustomizedTodoRepository {

}
