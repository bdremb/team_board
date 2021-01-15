package by.example.team_board.controller;

import by.example.team_board.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @GetMapping("/") // goToStartPage
    public String startPage() {
        return "start";
    }

    @GetMapping("/about")
    public String about() {    // глагол должен быть goToDetails
        return "about";
    }

    @GetMapping("/login")
    public String login(Model model) { //goToLoginPage
        model.addAttribute("person", new Person());
        return "login";
    }

    @GetMapping("/register")
    public String registerNewPerson(Model model) {  //goToRegisterPage
        model.addAttribute("person", new Person());
        return "register";
    }

    @GetMapping("/details")
    public String showDetails() {  // goToPersonDetails
        return "person-details";
    }
}
