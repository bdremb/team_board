package by.example.myteam.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExtraInfoDAOImpl implements ExtraInfoDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public ExtraInfoDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void deleteExtraInfoById(long id) {

    }
}
