package site.tellmetodo.todoapp.domain.todo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import site.tellmetodo.todoapp.domain.todo.dto.TodoListDto;
import site.tellmetodo.todoapp.domain.todo.service.TodoService;
import site.tellmetodo.todoapp.global.auth.security.UserDetailsImpl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

//    @GetMapping("/date/{date}")
//    public List<TodoListDto> getTodosByDate(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable("date") LocalDateTime date) {
//        Long id = userDetails.getUser().getId();
//
//        return todoService.getTodoListByUserIdAndDate(id, date);
//    }
//    @GetMapping
//    public String getTodoList(@AuthenticationPrincipal UserDetailsImpl userDetails) {
//        System.out.println(userDetails.getUsername());
//        return "";
//    }
}
