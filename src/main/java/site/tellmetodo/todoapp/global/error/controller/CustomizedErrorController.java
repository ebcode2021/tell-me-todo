package site.tellmetodo.todoapp.global.error.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;

public class CustomizedErrorController implements ErrorController {

    @GetMapping("/error")
    public String error() {
        return "error/404";
    }

}
