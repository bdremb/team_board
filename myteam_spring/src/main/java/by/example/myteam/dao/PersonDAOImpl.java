package by.example.myteam.dao;

import by.example.myteam.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonDAOImpl implements PersonDAO {
    final static Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);
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
        logger.info("Method getAllPerson completed successfully");
        return persons;
    }

    @Override
    public void savePerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(person);
        logger.info("SAVE PERSON completed successfully");
    }

    @Override
    public Person getPerson(int id) {
        Session session = sessionFactory.getCurrentSession();
        Optional<Person> optionalPerson = Optional.ofNullable(session.get(Person.class, id));
        if (optionalPerson.isPresent()) {
            logger.info("GET PERSON completed successfully");
            return optionalPerson.get();
        } else {
            logger.warn("GET PERSON ERROR, person with ID = " + id + " does not exist");
        }
        return null;
    }

    @Override
    public void deletePerson(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE from Person WHERE id = :personId");
        query.setParameter("personId", id);
        query.executeUpdate();
        logger.info("DELETE PERSON completed successfully");
    }





}
