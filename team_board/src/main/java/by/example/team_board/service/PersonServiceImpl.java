package by.example.team_board.service;

import by.example.team_board.dao.PersonDAO;
import by.example.team_board.entity.ExtraInfo;
import by.example.team_board.entity.Person;
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
    public boolean savePerson(Person person) {
        List<Person> persons = personDAO.getAllPersons();
        Optional<Person> authPerson = persons.stream()            // authPerson
                .filter(p -> p.getLogin().equals(person.getLogin()))
                .findAny();
        if (authPerson.isPresent()) {
            return false;
        }
        person.setExtraInfo(new ExtraInfo());
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
        List<Person> allPersons = personDAO.getAllPersons();
        Optional<Person> persons = allPersons.stream()             // persons
                .filter(p -> p.getLogin().equals(person.getLogin()))
                .findAny();
        if (persons.isPresent()) {
            Person newPerson = persons.get();
            String password = newPerson.getPassword();
            if (person.getPassword().equals(password)) {
                logger.info("Successful. Login == Password");
                return persons.get();
            }
        }
        logger.error("Person error. Password and login are not valid. Method returned null...");
        return null;
    }

    @Override
    @Transactional
    public ExtraInfo saveExtraInfoOfPerson(ExtraInfo extraInfo, Person person) {
        ExtraInfo info = personDAO.getPerson(person.getId()).getExtraInfo();   //apache commons
        info.setAge(extraInfo.getAge());
        info.setCity(extraInfo.getCity());
        info.setEmail(extraInfo.getEmail());
        info.setSkype(extraInfo.getSkype());
        info.setPhoneNumber(extraInfo.getPhoneNumber());
        return info;
    }
}