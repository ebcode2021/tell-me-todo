package site.tellmetodo.todoapp.domain.user.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import site.tellmetodo.todoapp.domain.user.dto.UserFormDto;
import site.tellmetodo.todoapp.domain.user.entity.User;
import site.tellmetodo.todoapp.domain.user.repository.UserRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("회원가입")
    void join() {
        // given
        UserFormDto userFormDto = UserFormDto.builder()
                .username("user_1")
                .password(passwordEncoder.encode("1234"))
                .email("test@gmail.com")
                .nickname("test user")
                .build();
        User user = userFormDto.toEntity();

        // mocking
        when(userRepository.save(any(User.class))).thenReturn(user);

        // when
        User savedMember = userService.join(userFormDto);

        // then
        Assertions.assertThat(savedMember.getUsername()).isEqualTo(userFormDto.getUsername());
        verify(userRepository, times(1)).save(any(User.class));
    }
}