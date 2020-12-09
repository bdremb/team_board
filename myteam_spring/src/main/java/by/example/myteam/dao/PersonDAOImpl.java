package by.example.myteam.dao;

import by.example.myteam.entity.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PersonDAOImpl implements PersonDAO{

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

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
