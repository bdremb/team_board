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
        Assert.assertEquals(personList.get(0).getName(), "Sergey");
        Assert.assertEquals(personList.get(1).getExtraInfo().getAge(), 12);
        Assert.assertEquals(personList.get(2).getExtraInfo().getEmail(), "dd@dd.com");
    }

    @Test
    public void testGetPerson() {
        Person testPerson = personService.getPerson(3);
        Assert.assertEquals(testPerson.getSurname(), "Sidorova");
        Assert.assertEquals(testPerson.getExtraInfo().getPhoneNumber(), "998877664");
    }

    @Test
    public void testValidateAndGetPerson() {
        Person person2 = personService.getPerson(2);
        Assert.assertEquals(person2, personService.validateAndGetPerson(person2));
        Assert.assertNull(personService.validateAndGetPerson(person));
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

    @Test
    public void testUpdateExtraInfoOfPerson() {
        Person personToUpdate = new Person();
        personToUpdate.setExtraInfo(new ExtraInfo());
        personToUpdate.getExtraInfo().setCity("ExampleCity");
        personToUpdate.getExtraInfo().setEmail("cucu@cucu.ff");
        personToUpdate.getExtraInfo().setAge(11);
        personToUpdate.setName("John");
        personToUpdate.setLogin("johnLogin987");
        personService.savePerson(personToUpdate);

        Person copyOfPersonWithNewExtraInfo = new Person();
        copyOfPersonWithNewExtraInfo.setExtraInfo(new ExtraInfo());
        copyOfPersonWithNewExtraInfo.setName(personToUpdate.getName());
        copyOfPersonWithNewExtraInfo.setLogin(personToUpdate.getLogin());
        copyOfPersonWithNewExtraInfo.setId(personToUpdate.getId());
        copyOfPersonWithNewExtraInfo.getExtraInfo().setCity("NewCity");
        copyOfPersonWithNewExtraInfo.getExtraInfo().setEmail("ExampleEmail@email.email");
        copyOfPersonWithNewExtraInfo.getExtraInfo().setAge(99);

        Assert.assertEquals(personToUpdate.getExtraInfo().getCity(), "ExampleCity");
        Assert.assertEquals(personToUpdate.getExtraInfo().getEmail(), "cucu@cucu.ff");
        Assert.assertEquals(personToUpdate.getExtraInfo().getAge(), 11);

        Person personToUpdateNew = personService.updateExtraInfoOfPerson(copyOfPersonWithNewExtraInfo);
        Assert.assertEquals(personToUpdate.getExtraInfo().getCity(), "NewCity");
        Assert.assertEquals(personToUpdate.getExtraInfo().getEmail(), "ExampleEmail@email.email");
        Assert.assertEquals(personToUpdate.getExtraInfo().getAge(), 99);
        Assert.assertEquals(personToUpdateNew, personToUpdate);

        personService.deletePerson(personToUpdate.getId());
    }

    @AfterClass
    public static void finished() {
        factory.getCurrentSession().getTransaction().commit();
        factory.close();
    }
}


