package site.tellmetodo.todoapp.domain.user.entity;

import lombok.*;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import site.tellmetodo.todoapp.global.entity.BaseEntity;

@Entity
@Table(name = "\"Users\"" )
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@EntityListeners(AuditingEntityListener.class)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String nickname;

    private String email;

    private String bio;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

}
