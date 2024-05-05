package site.tellmetodo.todoapp.domain.todo.repository;

import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import site.tellmetodo.todoapp.domain.todo.entity.Todo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static site.tellmetodo.todoapp.domain.todo.entity.QTodo.todo;

@Repository
@Transactional
@RequiredArgsConstructor
public class CustomizedTodoRepositoryImpl implements CustomizedTodoRepository {

    private final JPAQueryFactory jpaQueryFactory;

    private StringExpression formatDate(DateTimePath<LocalDateTime> datePath) {
        return Expressions.stringTemplate("TO_CHAR({0}, 'YYYY-MM-DD')", datePath);
    }

    @Override
    public List<Todo> findTodoListByUserIdAndDate(Long id, LocalDate date) {
        StringExpression formattedDate = formatDate(todo.created_at);

        return jpaQueryFactory.selectFrom(todo)
                .where(todo.user.id.eq(id)
                        .and(formattedDate.eq(date.toString())))
                .fetch();
    }

    @Override
    public void deleteTodoListByUserIdAndDate(Long id, LocalDate date) {
        StringExpression formattedDate = formatDate(todo.created_at);

        jpaQueryFactory.delete(todo)
            .where(todo.user.id.eq(id)
                .and(formattedDate.eq(date.toString())))
            .execute();
    }
}

