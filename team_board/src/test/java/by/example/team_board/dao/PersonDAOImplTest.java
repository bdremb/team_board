package by.example.team_board.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOImplTest extends PersonDAOImpl {


    public PersonDAOImplTest(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
