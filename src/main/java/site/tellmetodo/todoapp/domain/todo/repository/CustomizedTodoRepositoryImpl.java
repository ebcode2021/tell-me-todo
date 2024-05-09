package site.tellmetodo.todoapp.domain.todo.repository;

import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
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
                .orderBy(todo.created_at.asc())
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

    @Override
    public void reverseTodoFavorite(Long id) {
        JPAUpdateClause updateClause = jpaQueryFactory.update(todo)
                .where(todo.id.eq(id));
        updateClause.set(todo.favorite, todo.favorite.not())
                .execute();
    }

    @Override
    public void reverseTodoCompleted(Long id) {
        JPAUpdateClause updateClause = jpaQueryFactory.update(todo)
                .where(todo.id.eq(id));
        updateClause.set(todo.completed, todo.completed.not())
                .execute();
    }

    @Override
    public void updateTodoContent(Long id, String content) {
        JPAUpdateClause updateClause = jpaQueryFactory.update(todo)
                .where(todo.id.eq(id));
        updateClause.set(todo.content, content)
                .execute();

    }

}

