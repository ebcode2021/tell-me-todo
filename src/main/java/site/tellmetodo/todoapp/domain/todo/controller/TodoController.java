package site.tellmetodo.todoapp.domain.todo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import site.tellmetodo.todoapp.domain.todo.service.TodoService;
import site.tellmetodo.todoapp.global.auth.security.UserDetailsImpl;

import java.util.Date;

@Controller
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/date/{date}")
    public void getTodosByDate(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable("date") Date date) {
        Long id = userDetails.getUser().getId();

    }
//    @GetMapping
//    public String getTodoList(@AuthenticationPrincipal UserDetailsImpl userDetails) {
//        System.out.println(userDetails.getUsername());
//        return "";
//    }
}
