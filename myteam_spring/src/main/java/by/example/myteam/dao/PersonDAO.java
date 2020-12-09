package by.example.myteam.dao;

import by.example.myteam.entity.Person;

import java.util.List;

public interface PersonDAO {

    List<Person> getAllPerson();

    void savePerson(Person person);

    Person getPerson(long id);

    void deletePerson(long id);
}
