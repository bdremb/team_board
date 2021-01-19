package by.example.team_board.controller;

import by.example.team_board.entity.Person;
import by.example.team_board.page.Pages;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

  @GetMapping("/")
  public String goToStartPage() {
    return Pages.START.getPage();
  }

  @GetMapping("/about")
  public String goToDetails() {    // TODO: add javadoc
    return Pages.ABOUT.getPage();
  }

  @GetMapping("/login")
  public String goToLoginPage(Model model) {        // TODO: add javadoc
    model.addAttribute("person", new Person());
    return Pages.LOGIN.getPage();
  }

  @GetMapping("/register")
  public String goToRegisterPage(Model model) {
    model.addAttribute("person", new Person());
    return Pages.REGISTER.getPage();
  }

  @GetMapping("/details")
  public String goToPersonDetailsPage() {
    return Pages.PERSON_DETAILS.getPage();
  }
}
