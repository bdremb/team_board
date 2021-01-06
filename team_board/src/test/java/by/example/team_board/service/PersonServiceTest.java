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
    private static SessionFactory factory;
    private static PersonService personService;
    private static Person person;

    @BeforeClass
    public static void setUp() {
        factory = new Configuration().configure("test.hibernate.cfg.xml")
                .addAnnotatedClass(Person.class).addAnnotatedClass(ExtraInfo.class).buildSessionFactory();
        factory.getCurrentSession().beginTransaction();
        personService = new PersonServiceImpl(new PersonDAOImplTest(factory));
        person = new Person();
        person.setExtraInfo(new ExtraInfo());
        person.setName("Mikhail");
        person.setLogin("login123123123");
    }

    @Test
    public void testGetAllPersons() {
        List<Person> personList = personService.getAllPersons();
        for (Person person : personList) {
            System.out.println(person.getLogin() + " " + person.getGender());
        }
        Assert.assertEquals(personList.get(0).getName(), "Sergey");
        Assert.assertEquals(personList.get(1).getExtraInfo().getAge(), 12);
    }

    @Test
    public void testGetPerson() {
        Person testPerson = personService.getPerson(3);
        Assert.assertEquals(testPerson.getSurname(), "Sidorova");
        Assert.assertEquals(testPerson.getExtraInfo().getPhoneNumber(), "998877664");
    }

    @Test
    public void testSaveAndDeletePerson() {
        boolean result = personService.savePerson(person);
        Assert.assertTrue(result);
        boolean result2 = personService.savePerson(person);
        Assert.assertFalse(result2);
        personService.deletePerson(person.getId());
        Assert.assertNull(personService.getPerson(person.getId()));
    }

    @AfterClass
    public static void finished() {
        factory.getCurrentSession().getTransaction().commit();
        factory.close();
    }
}


