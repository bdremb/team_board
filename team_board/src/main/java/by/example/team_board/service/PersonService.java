package by.example.team_board.service;

import by.example.team_board.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAllPersons();

    boolean savePerson(Person person);

    Person getPerson(int id);

    void deletePerson(int id);

    Person validateAndGetPerson(Person person);

    Person updateExtraInfoOfPerson(Person person);
}
