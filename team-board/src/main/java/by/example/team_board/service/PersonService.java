package by.example.team_board.service;

import by.example.team_board.entity.Person;
import by.example.team_board.exceptions.PersonAlreadyExistException;
import by.example.team_board.page.Pages;

import java.util.List;

public interface PersonService {

  List<Person> getAllPersons();

  Pages savePerson(Person person) throws PersonAlreadyExistException;

  Person getPerson(int id);

  void deletePerson(int id);

  Person authorize(Person person);

  Person updateExtraInfoOfPerson(Person person);
}
