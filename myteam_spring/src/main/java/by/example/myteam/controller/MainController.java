package by.example.myteam.controller;

import by.example.myteam.entity.Person;
import by.example.myteam.service.ExtraInfoService;
import by.example.myteam.service.PersonServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/persons")
    public Person addNewPerson (@RequestBody Person person) {
        personServise.savePerson(person);
        return person;
    }
}
