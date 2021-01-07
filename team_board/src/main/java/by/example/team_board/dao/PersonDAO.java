package by.example.team_board.dao;

import by.example.team_board.entity.Person;
import java.util.List;

public interface PersonDAO {

    List<Person> getAllPersons();

    void savePerson(Person person);

    Person getPerson(int id);

    void deletePerson(int id);
}
