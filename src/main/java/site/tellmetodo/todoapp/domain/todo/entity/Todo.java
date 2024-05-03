package site.tellmetodo.todoapp.domain.todo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import site.tellmetodo.todoapp.domain.user.entity.User;
import site.tellmetodo.todoapp.global.entity.BaseEntity;

@Entity
@Table(name = "\"Todo\"")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
public class Todo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_Id", updatable = false)
    private User user;

    private String content;

    private boolean favorite;

    private boolean completed;

}
