package site.tellmetodo.todoapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
//        model.getAttribute("todoList", {});
//        model.addAttribute("user", "eunbi");
        return "home";

    }
}
