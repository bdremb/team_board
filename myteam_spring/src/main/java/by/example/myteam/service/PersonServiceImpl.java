package by.example.myteam.service;

import by.example.myteam.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonServise{
    @Override
    public List<Person> getAllPerson() {
        return null;
    }

    @Override
    public void savePerson(Person person) {

    }

    @Override
    public Person getPerson(long id) {
        return null;
    }

    @Override
    public void deletePerson(long id) {

    }
}
