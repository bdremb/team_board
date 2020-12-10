package by.example.myteam.controller;

import by.example.myteam.entity.Person;
import by.example.myteam.service.ExtraInfoService;
import by.example.myteam.service.PersonServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class MainController {

    private final PersonServise personServise;

    private final ExtraInfoService extraInfoService;

    @Autowired
    public MainController(PersonServise personServise, ExtraInfoService extraInfoService) {
        this.personServise = personServise;
        this.extraInfoService = extraInfoService;
    }

    @GetMapping("/persons")
    public List<Person> showAllPersons(Model model) {
        List<Person> persons = personServise.getAllPerson();
        model.addAttribute("persons", persons);
        return persons;
    }

    @PostMapping("/persons")
    public Person addNewPerson (@RequestBody Person person, Model model) {
        personServise.savePerson(person);
        model.addAttribute("person", person);
        return person;
    }


}
