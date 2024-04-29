package site.tellmetodo.todoapp.global.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class BaseEntity {

    @CreatedDate // Entity 생성시 자동 저장
    @Column(updatable = false, nullable = false)
    private LocalDateTime created_at;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updated_at;
}

/*
    순수 JPA -> @PrePersist, @PreUpdate의 기능
    Spring JPA -> @CreatedDate, @LastModifiedDate

    @MappedSuperclass
    : BaseEntity를 상속한 엔티티들은 아래 필드를 자동으로 컬럼으로 인식
 */
