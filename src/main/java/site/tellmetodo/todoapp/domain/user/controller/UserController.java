package site.tellmetodo.todoapp.domain.user.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import site.tellmetodo.todoapp.domain.user.dto.UserFormDto;
import site.tellmetodo.todoapp.domain.user.service.UserService;
import site.tellmetodo.todoapp.global.auth.security.UserDetailsImpl;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String home(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails == null) {
            log.info("이게 보인다는 것은 진짜 코드가 박살난거");
        }
        // userDetails에 있는 유저를 넘겨줘야 함
        return "user/home";
    }

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @GetMapping("/join")
    public String join(@ModelAttribute("userFormDto") UserFormDto userFormDto, Model model){
        model.addAttribute("userFormDto", userFormDto);
        return "user/join";
    }

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

    @GetMapping("/users/exists/{username}")
    public ResponseEntity<Boolean> existUser(@PathVariable("username") String username) {
        return userService.isUsername(username) ? ResponseEntity.ok(true) : ResponseEntity.ok(false);
    }


    @PostMapping("/users/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());

        return "redirect:/login";
    }

}

//    @GetMapping("/users/{userId}")
//    public void getUser(@PathVariable String userId) {

//    }