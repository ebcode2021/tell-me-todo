package site.tellmetodo.todoapp.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import site.tellmetodo.todoapp.domain.user.dto.LoginUserDto;
import site.tellmetodo.todoapp.domain.user.entity.User;
import site.tellmetodo.todoapp.domain.user.service.UserService;

import javax.swing.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping ("/")
    public void join() {
    }

    @GetMapping("/{userId}")
    public void getUser(@PathVariable String userId) {

    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginUserDto loginUser) {
        User user = userService.findUserByUsername(loginUser.getUsername());
        if (user != null) {
            System.out.println(user.toString());
        } else {
            System.out.println("유저 정보 없음");
        }
        return "redirect:/";
    }

    @PostMapping("/logout")
    public void logout() {

    }

}
