package by.example.myteam.service;

import by.example.myteam.dao.PersonDAO;
import by.example.myteam.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonServise {

    private final PersonDAO personDAO;

    @Autowired
    public PersonServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public List<Person> getAllPerson() {
        return null;
    }

    @Override
    public void savePerson(Person person) {
        personDAO.savePerson(person);
    }

    @Override
    public Person getPerson(long id) {
        return null;
    }

    @Override
    public void deletePerson(long id) {

    }
}
