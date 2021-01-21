package by.example.team_board.controller;

import by.example.team_board.entity.ExtraInfo;
import by.example.team_board.entity.Person;
import by.example.team_board.exceptions.PersonAlreadyExistException;
import by.example.team_board.page.Pages;
import by.example.team_board.service.PersonService;

import java.util.List;
import java.util.Objects;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Denis
 * @version 1.0
 */
@Controller
@RequestMapping("/team")
public class PersonController {
  final Logger logger = LoggerFactory.getLogger(PersonController.class);

  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  /**
   * @param model includes a list of all persons
   * @return list person page from Pages enum
   * @see Pages
   */
  @GetMapping("/persons")
  public String showAllPersons(Model model) {
    List<Person> persons = personService.getAllPersons();
    model.addAttribute("allPersons", persons);
    return Pages.LIST_PERSONS.getPage();
  }

  /**
   * @param id the Person id to show person details
   * @param model the Person
   * @return person-details page.
   * @summary show
   */
  @GetMapping("/persons/{id}")
  public String showPersonDetailsById(@PathVariable("id") int id, Model model) {
    Person person = personService.getPerson(id);
    model.addAttribute("person", person);
    return Pages.PERSON_DETAILS.getPage();
  }

  /**
   * @param person the Person to save
   * @param bindingResult new {@link Person} data entry errors
   * @param model the Person
   * @return
   */
  @PostMapping("/persons")
  public String saveNewPerson(@ModelAttribute("person") @Valid Person person,
                              BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      logger.error("Binding result has errors: " + bindingResult.toString());
      return Pages.REGISTER.getPage();
    }
    if (person.getPassword().equals(person.getConfirmPassword())) {
      person.setExtraInfo(new ExtraInfo());
      try {
        return personService.savePerson(person).getPage();
      } catch (PersonAlreadyExistException e) {
        logger.error("Person with login: <{}> already exist", person.getLogin());
        model.addAttribute("info", "Change your username");
        return Pages.ERROR_PAGE.getPage();
      }
    }
    model.addAttribute("info", "Change your password");
    model.addAttribute("page", "/register");
    return Pages.ERROR_PAGE.getPage();
  }

  /**
   * @param id the id of the Person to be deleted
   * @param model list of existing Persons
   * @return list person page from Pages enum
   */
  @GetMapping("/persons/delete/{id}")
  public String deletePerson(@PathVariable("id") int id, Model model) {
    personService.deletePerson(id);
    return showAllPersons(model);
  }

  /**
   * @param id the id of the Person to be update
   * @param model Person with updated data
   * @return the name of the person page
   */
  @GetMapping("/persons/update/{id}")
  public String updatePerson(@PathVariable("id") int id, Model model) {
    Person person = personService.getPerson(id);
    model.addAttribute("person", person);
    return Pages.PERSON_PAGE.getPage();
  }

  /**
   * @param person
   * @param model
   * @return
   */
  @PostMapping("/login")
  public String login(@ModelAttribute("person") Person person, Model model) {
    Person newPerson = personService.authorize(person);
    if (Objects.nonNull(newPerson)) {
      model.addAttribute("person", newPerson);
      logger.info("Login completed successfully.");
      return Pages.PERSON_PAGE.getPage();
    }
    return "redirect:/login";
  }

  /**
   * @param person
   * @param model
   * @return
   */
  @PostMapping("/addinfo")
  public String updateExtraInfoOfPerson(@ModelAttribute("person") Person person, Model model) {
    model.addAttribute("person", personService.updateExtraInfoOfPerson(person));
    return Pages.PERSON_PAGE.getPage();
  }
}
