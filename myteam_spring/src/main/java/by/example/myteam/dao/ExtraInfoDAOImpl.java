package by.example.myteam.dao;

import by.example.myteam.entity.ExtraInfo;
import org.hibernate.Session;
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

    @Override
    public void saveExtraInfo(ExtraInfo extraInfo) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(extraInfo);
    }

    @Override
    public ExtraInfo getExtraInfo(int id) {
        return null;
    }
}
