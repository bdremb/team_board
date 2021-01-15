package by.example.team_board.controller;

import by.example.team_board.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String goToStartPage() {
        return "start";
    }

    @GetMapping("/about")
    public String goToDetails() {    // TODO: add javadoc
        return "about";
    }

    @GetMapping("/login")
    public String goToLoginPage(Model model) {        // TODO: add javadoc
        model.addAttribute("person", new Person());
        return "login";
    }

    @GetMapping("/register")
    public String goToRegisterPage(Model model) {
        model.addAttribute("person", new Person());
        return "register";
    }

    @GetMapping("/details")
    public String goToPersonDetailsPage() {
        return "person-details";
    }
}
