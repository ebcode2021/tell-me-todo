package site.tellmetodo.todoapp.domain.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import site.tellmetodo.todoapp.domain.todo.dto.TodoListDto;
import site.tellmetodo.todoapp.domain.todo.entity.TodoSort;
import site.tellmetodo.todoapp.domain.todo.service.TodoService;
import site.tellmetodo.todoapp.domain.user.dto.UserFormDto;
import site.tellmetodo.todoapp.domain.user.service.UserService;
import site.tellmetodo.todoapp.global.auth.security.UserDetailsImpl;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final TodoService todoService;

    /**
     * @brief 로그인 후 접근 가능한 메인 페이지
     */
    @GetMapping("/")
    public String home(@AuthenticationPrincipal UserDetailsImpl userDetails,
                       @RequestParam(required = false, name = "sort") TodoSort sort,
                       Model model) {
        Long id = userDetails.getUser().getId();
        LocalDate date = LocalDate.now();

        List<TodoListDto> todoList = todoService.getTodoListByUserIdAndLocalDateAndSort(id, date, sort);
        model.addAttribute("todoList", todoList);

        return "user/home";
    }

    /**
     * @brief 로그인 페이지
     */
    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    /**
     * @brief guest 페이지
     */
    @GetMapping("/guest")
    public String guest() {
        return "user/guest-home";
    }

    /**
     * @brief 회원가입 페이지
     */
    @GetMapping("/join")
    public String join(@ModelAttribute("userFormDto") UserFormDto userFormDto, Model model){
        model.addAttribute("userFormDto", userFormDto);
        return "user/join";
    }

    /**
     * @brief 새로운 유저 등록
     */
    @PostMapping ("/users")
    public String addUser(@Valid @ModelAttribute UserFormDto userFormDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/join";
        }
        if (userService.join(userFormDto) == null) {
            log.error("사용자 추가에 실패하였습니다.");
        };
        return "redirect:/";
    }

    /**
     * @brief 닉네임 중복 체크
     */
    @GetMapping("/users/exists/{username}")
    public ResponseEntity<Boolean> existUser(@PathVariable("username") String username) {
        return userService.isUsername(username) ? ResponseEntity.ok(true) : ResponseEntity.ok(false);
    }

    /**
     * @brief 마이 페이지 (개발중)
     */
    @GetMapping("/myPage")
    public String myPage() {
        return "user/myPage";
    }
}