package by.example.myteam.controller;

import by.example.myteam.entity.Person;
import by.example.myteam.service.ExtraInfoService;
import by.example.myteam.service.PersonServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/team")
public class MainController {

    private final PersonServise personServise;



    @Autowired
    public MainController(PersonServise personServise) {
        this.personServise = personServise;

    }

    @GetMapping("/persons")
    public String showAllPersons(Model model) {
        List<Person> pers = personServise.getAllPerson();
        model.addAttribute("allPersons", pers);
        return "list-persons";
    }

    @GetMapping("/persons/{id}")
    public String showPersonDetailsById (@PathVariable ("id") int id, Model model) {
        Person person = personServise.getPerson(id);
        model.addAttribute("person", person);
        return "person-details";
    }


    @PostMapping("/persons")
    public String saveNewPerson(@ModelAttribute("person") Person pers) {
        personServise.savePerson(pers);
        return "/login";
    }




}
