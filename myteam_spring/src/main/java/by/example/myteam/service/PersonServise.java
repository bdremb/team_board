package by.example.myteam.service;

import by.example.myteam.entity.Person;

import java.util.List;

public interface PersonServise {

    List<Person> getAllPerson();

    boolean savePerson(Person person);

    Person getPerson(int id);

    void deletePerson(int id);

     Person validateAndGetPerson(Person person);
}
