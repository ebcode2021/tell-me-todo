package site.tellmetodo.todoapp.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import site.tellmetodo.todoapp.domain.user.dto.UserFormDto;
import site.tellmetodo.todoapp.domain.user.entity.User;
import site.tellmetodo.todoapp.domain.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User join(UserFormDto userFormDto) {
        userFormDto.setPassword(passwordEncoder.encode(userFormDto.getPassword()));
        return userRepository.save(userFormDto.toEntity());
    }

    @Override
    public Boolean isUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}