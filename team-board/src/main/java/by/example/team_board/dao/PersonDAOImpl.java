package by.example.team_board.dao;

import by.example.team_board.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public List<Person> getAllPersons() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Person ", Person.class)  //constant query
                .getResultList();
    }

    @Override
    public void savePerson(Person person) {
        sessionFactory.getCurrentSession().saveOrUpdate(person);
        logger.info("Person was saved."); //person with id = {} was saved
    }

    @Override
    public Person getPerson(int id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession()
                .get(Person.class, id)).orElse(null);
    }

    @Override
    public void deletePerson(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(Person.class, id));
        logger.info("Successful, person was deleted."); // person with id = {} was deleted
    }
}
