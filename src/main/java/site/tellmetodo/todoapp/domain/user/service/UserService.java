package site.tellmetodo.todoapp.domain.user.service;

import site.tellmetodo.todoapp.domain.user.entity.User;

public interface UserService {

    User findUserByUsername(String username);
}
