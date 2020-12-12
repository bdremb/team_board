package by.example.myteam.controller;

import by.example.myteam.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("/about")
    public String about() {
        return "about";
    }


    @GetMapping("/login")
    public String login(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "login";
    }

    @GetMapping("/register")
    public String registerNewPerson(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "register";
    }

    @RequestMapping("/details")
    public String showDetails() {
        return "person-details";
    }


}
