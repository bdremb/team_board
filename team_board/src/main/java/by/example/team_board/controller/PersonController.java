package by.example.team_board.controller;

import by.example.team_board.entity.ExtraInfo;
import by.example.team_board.entity.Person;
import by.example.team_board.service.ExtraInfoService;
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

@Controller
@RequestMapping("/team")
public class PersonController {
    final static Logger logger = LoggerFactory.getLogger(PersonController.class);

    private final PersonService personService;
    private final ExtraInfoService extraInfoService;

    @Autowired
    public PersonController(PersonService personService, ExtraInfoService extraInfoService) {
        this.personService = personService;
        this.extraInfoService = extraInfoService;
    }

    @GetMapping("/persons")
    public String showAllPersons(Model model) {
        List<Person> persons = personService.getAllPersons();
        model.addAttribute("allPersons", persons);
        return "list-persons";
    }

    @GetMapping("/persons/{id}")
    public String showPersonDetailsById(@PathVariable("id") int id, Model model) {
        Person person = personService.getPerson(id);
        model.addAttribute("person", person);
        return "person-details";
    }

    @PostMapping("/persons")
    public String saveNewPerson(@ModelAttribute("person") @Valid Person person,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            logger.error("binding result has errors");
            return "register";
        }
        if (person.getPassword().equals(person.getConfirmPassword())) {
            if (personService.savePerson(person)) {
                return "login";
            }
        }
        model.addAttribute("info", "Измените логин или проверьте правильность подтверждения пароля");
        model.addAttribute("page", "/register");
        return "error-page";
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
        model.addAttribute("extrainfo", person.getExtraInfo());  // зачем
        return "person-page";
    }

    @PostMapping("/login")
    public String enter(@ModelAttribute("person") Person person, Model model) {
        Person newPerson = personService.validateAndGetPerson(person);
        if (newPerson != null) {                                //not null   ,Objects not null
            model.addAttribute("person", newPerson);
            model.addAttribute("extrainfo", newPerson.getExtraInfo()); // так не должно быть
            logger.info("enter to the person page");
            return "person-page";
        }
        return "redirect:/login";
    }

    @PostMapping("/addinfo")
    public String saveExtraInfoOfPerson(@ModelAttribute("extrainfo") ExtraInfo extraInfo,   //переделать, убрать
                                        @ModelAttribute("person") Person person, Model model) {
        ExtraInfo info = personService.saveExtraInfoOfPerson(extraInfo, person);
        extraInfoService.saveExtraInfo(info);
        model.addAttribute("person", info.getPerson());
        return "person-page";
    }
}
