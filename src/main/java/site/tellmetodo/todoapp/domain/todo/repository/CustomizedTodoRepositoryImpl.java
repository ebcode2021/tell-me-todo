package site.tellmetodo.todoapp.domain.todo.repository;

import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import site.tellmetodo.todoapp.domain.todo.dto.TodoListDto;
import site.tellmetodo.todoapp.domain.todo.entity.Todo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static site.tellmetodo.todoapp.domain.todo.entity.QTodo.todo;

@Repository
@RequiredArgsConstructor
public class CustomizedTodoRepositoryImpl implements CustomizedTodoRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Todo> findTodoListByUserIdAndDate(Long id, LocalDate date) {
        StringExpression formattedDate = Expressions.stringTemplate("TO_CHAR({0}, 'YYYY-MM-DD')", todo.created_at);

        return jpaQueryFactory.selectFrom(todo)
                .where(todo.user.id.eq(id)
                        .and(formattedDate.eq(date.toString())))
                .fetch();
    }
}

