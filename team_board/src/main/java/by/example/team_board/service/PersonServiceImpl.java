package by.example.team_board.service;

import by.example.team_board.dao.PersonDAO;
import by.example.team_board.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    final static Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);
    private final PersonDAO personDAO;

    @Autowired
    public PersonServiceImpl(@Qualifier("personDAOImpl") PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    @Transactional
    public List<Person> getAllPersons() {
        return personDAO.getAllPersons();
    }

    @Override
    @Transactional
    public boolean savePerson(Person person) {
        if (personDAO.getAllPersons()
                .stream()
                .anyMatch(p -> p.getLogin().equals(person.getLogin()))) {
            return false;
        }
        personDAO.savePerson(person);
        return true;
    }

    @Override
    @Transactional
    public Person getPerson(int id) {
        Person person = personDAO.getPerson(id);
        if (Objects.nonNull(person)) {
            return person;
        }
        logger.info("Person with id = {} does not exists.", id);
        return null;
    }

    @Override
    @Transactional
    public void deletePerson(int id) {
        personDAO.deletePerson(id);
    }

    @Override
    @Transactional
    public Person validateAndGetPerson(Person person) {
        Optional<Person> persons = personDAO.getAllPersons().stream()
                .filter(p -> p.getLogin().equals(person.getLogin()))
                .findAny();
        if (persons.isPresent() && (person.getPassword().equals(persons.get().getPassword()))) {
            logger.info("Successful, person was validated.");
            return persons.get();
        }
        logger.error("Error. Person was not validated.");
        return null;
    }

    @Override
    @Transactional
    public Person updateExtraInfoOfPerson(Person person) {
        Person updatedPerson = personDAO.getPerson(person.getId());
        updatedPerson.setExtraInfo(person.getExtraInfo());
        logger.info("Successful, person was updated.");
        return updatedPerson;
    }
}
