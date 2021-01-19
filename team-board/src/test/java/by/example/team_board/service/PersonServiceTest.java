package by.example.team_board.service;

import by.example.team_board.config.TestConfig;
import by.example.team_board.dao.PersonDAO;
import by.example.team_board.dao.PersonDAOImpl;
import by.example.team_board.entity.ExtraInfo;
import by.example.team_board.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;


@Component
public class PersonServiceTest {

    private static final SessionFactory sessionFactory = TestConfig.sessionFactory().getObject();

    private static PersonServiceImpl personService;
    private static Person testPerson1;
    private static Person testPerson2;
    private static EmbeddedDatabase db;


    @BeforeClass
    public static void setUp() throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        testPerson1 = new Person(1,"Michail", "Petrov", "login123123123", "man", "a","a",new ExtraInfo());
        testPerson1.setExtraInfo(new ExtraInfo(1,"skypeMich", "Moscow", "+7(920)234-23-23", 32, "m", testPerson1));
        testPerson2 = new Person(2,"John", "Johnson", "johnLogin987", "man", "b", "b", new ExtraInfo());
        testPerson2.setExtraInfo(new ExtraInfo(2,"johnSkype", "London", "+1(23)555-55-55", 22, "v", testPerson2));

        session.save(testPerson1);
        session.save(testPerson2);
        transaction.commit();
        session.close();
        PersonDAO personDAO = new PersonDAOImpl(sessionFactory);
        personService = new PersonServiceImpl(personDAO);
//        db = new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .addScript("db/sql/create-db.sql")
//                .addScript("db/sql/insert-data.sql")
//                .build();


//        personDAO.savePerson(testPerson1);
//        personDAO.savePerson(testPerson2);


    }


    @Test
    public void getAllPersonsTest() {

        List<Person> personList = personService.getAllPersons();
        Assert.assertEquals(personList.get(0).getName(), "Sergey");
        Assert.assertEquals(personList.get(1).getExtraInfo().getAge(), 12);
        Assert.assertEquals(personList.get(2).getExtraInfo().getEmail(), "dd@dd.com");
    }

    @Test
    public void getPersonTest() {
        Person testPerson = personService.getPerson(3);
        Assert.assertEquals(testPerson.getSurname(), "Sidorova");
        Assert.assertEquals(testPerson.getExtraInfo().getPhoneNumber(), "998877664");
    }
//
//    @Test
//    public void validateAndGetPersonTest() {
//        Person person2 = personService.getPerson(2);
//        Assert.assertEquals(person2, personService.validateAndGetPerson(person2));
//        Assert.assertNull(personService.validateAndGetPerson(testPerson1));
//    }
//
//    @Test
//    public void saveAndDeletePersonTest() {
//        boolean result = personService.savePerson(testPerson1);
//        Assert.assertTrue(result);
//        boolean result2 = personService.savePerson(testPerson1);
//        Assert.assertFalse(result2);
//        personService.deletePerson(testPerson1.getId());
//        Assert.assertNull(personService.getPerson(testPerson1.getId()));
//    }
//
//    @Test
//    public void updateExtraInfoOfPersonTest() {
//        personService.savePerson(testPerson2);
//        Person personWithNewExtraInfo =
//                new Person(testPerson2.getName(), testPerson2.getSurname(), testPerson2.getLogin());
//        personWithNewExtraInfo.setId(testPerson2.getId());
//        personWithNewExtraInfo.setExtraInfo(
//                new ExtraInfo("newJohn", "NewLondon", "+7-111-222-33-44", 99));
//
//        Assert.assertNotEquals(personWithNewExtraInfo, testPerson2);
//        Assert.assertEquals(personService.updateExtraInfoOfPerson(personWithNewExtraInfo), testPerson2);
//        personService.deletePerson(testPerson2.getId());
//    }

    @AfterClass
    public static void cleanup() {
        db.shutdown();
        sessionFactory.close();


    }

}


