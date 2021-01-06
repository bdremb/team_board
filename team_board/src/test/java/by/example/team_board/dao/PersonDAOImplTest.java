package by.example.team_board.dao;

import by.example.team_board.entity.ExtraInfoTest;
import by.example.team_board.entity.PersonTest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class PersonDAOImplTest {

    private final SessionFactory sessionFactory;

    public PersonDAOImplTest(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public List<PersonTest> getAllPersons() {
        return sessionFactory.getCurrentSession()
                .createQuery("from PersonTest ", PersonTest.class)
                .getResultList();
    }


    public void savePerson(PersonTest personTest) {
        sessionFactory.getCurrentSession().saveOrUpdate(personTest);

    }

    public void updateExtraInfoOfPerson(PersonTest personTest, int extraInfoTestId) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(ExtraInfoTest.class, extraInfoTestId));
        session.saveOrUpdate(personTest);
    }

    public PersonTest getPerson(int id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession()
                .get(PersonTest.class, id)).orElse(null);
    }

    public void deletePerson(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(PersonTest.class, id));
    }
}
