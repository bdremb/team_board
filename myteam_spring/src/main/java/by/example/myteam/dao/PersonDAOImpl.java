package by.example.myteam.dao;

import by.example.myteam.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Person> getAllPerson() {
        Session session = sessionFactory.getCurrentSession();
        List<Person> persons = session.createQuery("from Person ", Person.class)
                .getResultList();
        return persons;
    }

    @Override
    public void savePerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(person);
    }

    @Override
    public Person getPerson(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Person.class, id);
    }

    @Override
    public void deletePerson(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE from Person WHERE id = :personId");
        query.setParameter("personId", id);
        query.executeUpdate();
    }
}
