package site.tellmetodo.todoapp.domain.todo.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import site.tellmetodo.todoapp.domain.todo.service.TodoService;
import site.tellmetodo.todoapp.global.auth.security.UserDetailsImpl;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    @DeleteMapping("/{date}")
    public void removeTodoListByDate(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                     @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                     HttpServletResponse response) {
        Long id = userDetails.getUser().getId();
        todoService.removeTodoListByDate(id, date);

    }

}

//    @GetMapping
//    public String getTodoList(@AuthenticationPrincipal UserDetailsImpl userDetails) {
//        System.out.println(userDetails.getUsername());
//        return "";
//    }
