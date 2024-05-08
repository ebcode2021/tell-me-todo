package site.tellmetodo.todoapp.domain.todo.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import site.tellmetodo.todoapp.domain.todo.dto.TodoCreateDto;
import site.tellmetodo.todoapp.domain.todo.service.TodoService;
import site.tellmetodo.todoapp.global.auth.security.UserDetailsImpl;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    /**
     * @brief Todo 추가
     */
    @PostMapping
    public String addTodo(@AuthenticationPrincipal UserDetailsImpl userDetails,
                          @ModelAttribute("content") String content) {
        todoService.addTodo(new TodoCreateDto(userDetails.getUser(), content));
        return "redirect:/";
    }

    /**
     * @brief Todo 삭제
     */
    @DeleteMapping("/{id}")
    public void removeTodo(@PathVariable("id") Long id,
                           HttpServletResponse response) {
        todoService.removeTodo(id);
    }

    /**
     * @brief Todo 내용 수정
     */
    @PatchMapping("/{id}/favorite")
    public void editTodoContent(@PathVariable("id") Long id,
                                HttpServletResponse response) {
        todoService.editTodoFavorite(id);
    }

    /**
     * @brief Todo 완료여부 수정
     */
    @PatchMapping("/{id}/completed")
    public void editTodoCompleted(@PathVariable("id") Long id,
                                    HttpServletResponse response) {
        todoService.editTodoCompleted(id);
    }

    /**
     * @brief 특정 날짜의 Todo List 삭제
     */
    @DeleteMapping("/date/{date}")
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
