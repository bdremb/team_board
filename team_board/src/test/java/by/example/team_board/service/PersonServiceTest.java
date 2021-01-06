package by.example.team_board.service;

import by.example.team_board.dao.PersonDAOImplTest;
import by.example.team_board.entity.ExtraInfo;
import by.example.team_board.entity.Person;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceTest {
    private static PersonDAOImplTest personDAOImplTest;
    private static SessionFactory factory;

    @BeforeClass
    public static void setUp() {
        factory = new Configuration().configure("test.hibernate.cfg.xml")
                .addAnnotatedClass(Person.class).addAnnotatedClass(ExtraInfo.class).buildSessionFactory();
        factory.getCurrentSession().beginTransaction();
        personDAOImplTest = new PersonDAOImplTest(factory);
    }

    @Test
    public void testGetAllPersons() {
        List<Person> personList = personDAOImplTest.getAllPersons();
        for (Person person : personList) {
            System.out.println(person.getLogin() + " " + person.getGender());
        }
        Assert.assertEquals(personList.get(0).getName(), "Sergey");
        Assert.assertEquals(personList.get(1).getExtraInfo().getAge(), 12);
    }

    @AfterClass
    public static void finished() {
        factory.getCurrentSession().getTransaction().commit();
        factory.close();
    }
}


