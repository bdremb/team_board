package by.example.myteam.service;

import by.example.myteam.dao.PersonDAO;
import by.example.myteam.entity.ExtraInfo;
import by.example.myteam.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    final static Logger logger = LoggerFactory.getLogger("Person Service");
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
    public boolean savePerson(Person person) {
        List<Person> allPerson = personDAO.getAllPerson();
        Optional<Person> login = allPerson.stream()
                .filter(p -> p.getLogin().equals(person.getLogin()))
                .findAny();
        if (login.isPresent()) {
            return false;
        }

        personDAO.savePerson(person);
        return true;
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

    @Override
    @Transactional
    public Person validateAndGetPerson(Person person) {
        List<Person> allPerson = personDAO.getAllPerson();
        Optional<Person> login = allPerson.stream()
                .filter(p -> p.getLogin().equals(person.getLogin()))
                .findAny();
        if (login.isPresent()) {
            Person newPerson = login.get();
            String password = newPerson.getPassword();
            if (person.getPassword().equals(password)) {
                logger.info("Successful. Login == Password");
                return login.get();
            }
        }
        logger.error("Person error. Password and login are not valid. Method returned null...");
        return null;
    }
}
