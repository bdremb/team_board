package by.example.myteam.service;

import by.example.myteam.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PersonServise {

    List<Person> getAllPerson();

    void savePerson(Person person);

    Person getPerson(long id);

    void deletePerson(long id);
}
