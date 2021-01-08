package by.example.team_board.dao;

import org.hibernate.SessionFactory;

public class PersonDAOImplTest extends PersonDAOImpl {
    public PersonDAOImplTest(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
