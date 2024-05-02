package site.tellmetodo.todoapp.domain.user.entity;

import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import site.tellmetodo.todoapp.domain.user.dto.UserFormDto;
import site.tellmetodo.todoapp.global.entity.BaseEntity;

@Entity
@Table(name = "\"User\"" )
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String nickname;

    private String email;

    private String bio;

    @Column(columnDefinition = "varchar(10) default 'ACTIVE'")
    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.ACTIVE;

    private User(String username, String password, String nickname, String email) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }

    public static User createUser(UserFormDto user) {
        return new User(user.getUsername(), user.getPassword(), user.getNickname(), user.getEmail());
    }

}
