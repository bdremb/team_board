package by.example.team_board.service;

import by.example.team_board.entity.ExtraInfo;
import by.example.team_board.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAllPerson();

    boolean savePerson(Person person);

    Person getPerson(int id);

    void deletePerson(int id);

    Person validateAndGetPerson(Person person);

    ExtraInfo saveExtraInfoOfPerson(ExtraInfo extraInfo, Person p);
}
