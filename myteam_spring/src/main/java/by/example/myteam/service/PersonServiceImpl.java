package by.example.myteam.service;

import by.example.myteam.dao.PersonDAO;
import by.example.myteam.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonServise {

    private final PersonDAO personDAO;

    @Autowired
    public PersonServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    @Transactional
    public List<Person> getAllPerson() {
        return personDAO.getAllPerson();
    }

    @Override
    @Transactional
    public void savePerson(Person person) {
        personDAO.savePerson(person);
    }

    @Override
    @Transactional
    public Person getPerson(int id) {
        return personDAO.getPerson(id);
    }

    @Override
    @Transactional
    public void deletePerson(int id) {
        personDAO.deletePerson(id);
    }
}
