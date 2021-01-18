package by.example.team_board.controller;

import by.example.team_board.entity.ExtraInfo;
import by.example.team_board.entity.Person;
import by.example.team_board.page.Pages;
import by.example.team_board.service.PersonService;
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

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/team")
public class PersonController {
    final static Logger logger = LoggerFactory.getLogger(PersonController.class);

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public String showAllPersons(Model model) {
        List<Person> persons = personService.getAllPersons();
        model.addAttribute("allPersons", persons);
        return Pages.list_persons.toString();
    }

    @GetMapping("/persons/{id}")
    public String showPersonDetailsById(@PathVariable("id") int id, Model model) {
        Person person = personService.getPerson(id);
        model.addAttribute("person", person);
        return Pages.person_details.toString();
    }

    @PostMapping("/persons")
    public String saveNewPerson(@ModelAttribute("person") @Valid Person person,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            logger.error("Binding result has errors: " + bindingResult.toString());
            return Pages.register.toString();
        }
        if (person.getPassword().equals(person.getConfirmPassword())) {
            person.setExtraInfo(new ExtraInfo());
            if (personService.savePerson(person)) {
                return Pages.login.toString();
            }
        }
        model.addAttribute("info", "Change your username or check your password");
        model.addAttribute("page", "/register");
        return Pages.error_page.toString();
    }

    @GetMapping("/persons/delete/{id}")
    public String deletePerson(@PathVariable("id") int id, Model model) {
        personService.deletePerson(id);
        return showAllPersons(model);
    }

    @GetMapping("/persons/update/{id}")
    public String updatePerson(@PathVariable("id") int id, Model model) {
        Person person = personService.getPerson(id);
        model.addAttribute("person", person);
        return Pages.error_page.toString();
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("person") Person person, Model model) {
        Person newPerson = personService.authorize(person);
        if (Objects.nonNull(newPerson)) {
            model.addAttribute("person", newPerson);
            logger.info("Login completed successfully.");
            return Pages.person_page.toString();                   //TODO enum
        }
        return "redirect:/login";
    }

    @PostMapping("/addinfo")
    public String updateExtraInfoOfPerson(@ModelAttribute("person") Person person, Model model) {
        model.addAttribute("person", personService.updateExtraInfoOfPerson(person));
        return Pages.person_page.toString();
    }
}
