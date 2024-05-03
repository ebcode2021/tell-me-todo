package site.tellmetodo.todoapp.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.tellmetodo.todoapp.domain.user.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, CustomizedUserRepository {

        Optional<User> findUserByUsername(String username);

        boolean existsByUsername(String username);

}

/*
       간단한 쿼리나  CRUD 작업 -> JPA 네이밍 컨벤션
       복잡한 쿼리나 유연성 -> queryDSL
 */
