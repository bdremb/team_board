package by.example.team_board.service;

import by.example.team_board.dao.PersonDAO;
import by.example.team_board.entity.Person;
import by.example.team_board.exceptions.AuthorizedException;
import by.example.team_board.exceptions.PersonAlreadyExistException;
import by.example.team_board.page.Pages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    final static Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);
    private final PersonDAO personDAO;

    @Autowired
    public PersonServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    @Transactional
    public List<Person> getAllPersons() {
        return personDAO.getAllPersons();
    }

    @Override
    @Transactional
    public Pages savePerson(Person person) throws PersonAlreadyExistException {
        if (personDAO.getAllPersons()
                .stream()
                .anyMatch(p -> p.getLogin().equals(person.getLogin()))) {
            throw new PersonAlreadyExistException("Person already exist");
        }
        personDAO.savePerson(person);
        return Pages.LOGIN;
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
    public Person authorize(Person person) {
        Optional<Person> persons = personDAO.getAllPersons().stream()
                .filter(p -> p.getLogin().equals(person.getLogin()))
                .findAny();
        try {
            if (!persons.isPresent() || !(person.getPassword().equals(persons.get().getPassword()))) {
                throw new AuthorizedException("Authentication error");
            }
        } catch (AuthorizedException e) {
            logger.error(e.getMessage());
        }
        return persons.get();
    }

    @Override
    @Transactional
    public Person updateExtraInfoOfPerson(Person person) {
        Person updatedPerson = personDAO.getPerson(person.getId());
        updatedPerson.setExtraInfo(person.getExtraInfo());
        logger.info("Person with login <{}> was updated.", person.getLogin());
        return updatedPerson;
    }
}
