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

import java.util.List;

public class PersonServiceTest {
    private static SessionFactory factory;
    private static PersonService personService;
    private static Person testPerson1;
    private static Person testPerson2;

    @BeforeClass
    public static void setUp() {
        factory = new Configuration().configure("test.hibernate.cfg.xml")
                .addAnnotatedClass(Person.class).addAnnotatedClass(ExtraInfo.class).buildSessionFactory();
        factory.getCurrentSession().beginTransaction();
        personService = new PersonServiceImpl(new PersonDAOImplTest(factory));

        testPerson1 = new Person("Michail", "Petrov", "login123123123");
        testPerson1.setExtraInfo(new ExtraInfo("skypeMich", "Moscow", "+7(920)234-23-23", 32));

        testPerson2 = new Person("John", "Johnson", "johnLogin987");
        testPerson2.setExtraInfo(new ExtraInfo("johnSkype", "London", "+1(23)555-55-55", 22));
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

    @Test
    public void validateAndGetPersonTest() {
        Person person2 = personService.getPerson(2);
        Assert.assertEquals(person2, personService.validateAndGetPerson(person2));
        Assert.assertNull(personService.validateAndGetPerson(testPerson1));
    }

    @Test
    public void saveAndDeletePersonTest() {
        boolean result = personService.savePerson(testPerson1);
        Assert.assertTrue(result);
        boolean result2 = personService.savePerson(testPerson1);
        Assert.assertFalse(result2);
        personService.deletePerson(testPerson1.getId());
        Assert.assertNull(personService.getPerson(testPerson1.getId()));
    }

    @Test
    public void updateExtraInfoOfPersonTest() {
        personService.savePerson(testPerson2);
        Person personWithNewExtraInfo =
                new Person(testPerson2.getName(), testPerson2.getSurname(), testPerson2.getLogin());
        personWithNewExtraInfo.setId(testPerson2.getId());
        personWithNewExtraInfo.setExtraInfo(
                new ExtraInfo("newJohn", "NewLondon", "+7-111-222-33-44", 99));

        Assert.assertNotEquals(personWithNewExtraInfo, testPerson2);
        Assert.assertEquals(personService.updateExtraInfoOfPerson(personWithNewExtraInfo), testPerson2);
        personService.deletePerson(testPerson2.getId());
    }

    @AfterClass
    public static void finished() {
        factory.getCurrentSession().getTransaction().commit();
        factory.close();
    }
}


