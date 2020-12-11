package by.example.myteam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("login")
    public String login() {
        return "login";
    }
}
