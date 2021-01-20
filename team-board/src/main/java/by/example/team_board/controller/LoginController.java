package by.example.team_board.controller;

import by.example.team_board.entity.Person;
import by.example.team_board.page.Pages;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Bdremb
 * @since 1.0
 */
@Controller
public class LoginController {
  /**
   * @return the name of the start page
   */
  @GetMapping("/")
  public String goToStartPage() {
    return Pages.START.getPage();
  }

  /**
   * @return the name of the details page
   */
  @GetMapping("/about")
  public String goToDetails() {    // TODO: add javadoc
    return Pages.DETAILS.getPage();
  }

  /**
   * @param model takes a new Person object
   * @return the name of the login page
   */
  @GetMapping("/login")
  public String goToLoginPage(Model model) {
    model.addAttribute("person", new Person());
    return Pages.LOGIN.getPage();
  }

  /**
   * @param model takes a new Person object
   * @return the name of the login page
   */
  @GetMapping("/register")
  public String goToRegisterPage(Model model) {
    model.addAttribute("person", new Person());
    return Pages.REGISTER.getPage();
  }

  /**
   * @return the name of the person details page
   */
  @GetMapping("/details")
  public String goToPersonDetailsPage() {
    return Pages.PERSON_DETAILS.getPage();
  }
}
