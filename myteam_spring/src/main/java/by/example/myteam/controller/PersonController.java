package by.example.myteam.controller;


import by.example.myteam.entity.Person;
import by.example.myteam.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/team")
public class PersonController {
    final static Logger logger = LoggerFactory.getLogger(PersonController.class);
    private final PersonService personServise;

    @Autowired
    public PersonController(PersonService personServise) {
        this.personServise = personServise;
    }

    @GetMapping("/persons")
    public String showAllPersons(Model model) {
        List<Person> pers = personServise.getAllPerson();
        model.addAttribute("allPersons", pers);
        return "list-persons";
    }

    @GetMapping("/persons/{id}")
    public String showPersonDetailsById(@PathVariable("id") int id, Model model) {
        Person person = personServise.getPerson(id);
        model.addAttribute("person", person);
        return "person-details";
    }

    @PostMapping("/persons")
    public String saveNewPerson(@ModelAttribute("person") @Valid Person pers,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            logger.error("binding result has errors");
            return "register";
        }
        if (pers.getPassword().equals(pers.getConfirmPassword())) {
            if(personServise.savePerson(pers)) {
                return "login";
            }
        }
        model.addAttribute("info", "Измените логин или проверьте правильность подтверждения пароля");
        model.addAttribute("page", "/register");
        return "error-page";
    }

    @GetMapping("/persons/delete/{id}")
    public String deletePerson(@PathVariable("id") int id, Model model) {
        personServise.deletePerson(id);
        List<Person> pers = personServise.getAllPerson();
        model.addAttribute("allPersons", pers);
        return "list-persons";
    }

    @PostMapping("/login")
    public String enter(@ModelAttribute("person") Person person, Model model) {
        Person newPerson = personServise.validateAndGetPerson(person);
        if (newPerson != null) {
            model.addAttribute("person", newPerson);
            return "person-page";
        }
        return "redirect:/login";
    }
}