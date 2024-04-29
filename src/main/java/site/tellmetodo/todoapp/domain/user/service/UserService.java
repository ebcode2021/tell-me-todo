package site.tellmetodo.todoapp.domain.user.service;

import site.tellmetodo.todoapp.domain.user.dto.UserFormDto;
import site.tellmetodo.todoapp.domain.user.entity.User;

public interface UserService {

//    User findUserByUsername(String username);

    User join(UserFormDto userFormDto);

    Boolean isUsername(String username);
}
