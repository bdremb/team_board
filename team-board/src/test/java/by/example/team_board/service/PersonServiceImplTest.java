package by.example.team_board.service;

import by.example.team_board.config.TestConfig;
import by.example.team_board.dao.PersonDAO;
import by.example.team_board.dao.PersonDAOImpl;
import by.example.team_board.entity.ExtraInfo;
import by.example.team_board.entity.Person;
import by.example.team_board.exceptions.PersonAlreadyExistException;
import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;

import java.util.List;

public class PersonServiceImplTest extends TestCase {

  @Autowired
  private static SessionFactory sessionFactory;

  private static PersonServiceImpl personService;
  private static Person testPerson1;
  private static Person testPerson2;
  private static EmbeddedDatabase db;



  public void setUp() throws Exception {
    super.setUp();
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    testPerson1 = new Person(1, "Michail", "Petrov", "login123123123", "man", "a", "a", new ExtraInfo());
    testPerson1.setExtraInfo(new ExtraInfo(1, "skypeMich", "Moscow", "+7(920)234-23-23", 32, "m", testPerson1));
    testPerson2 = new Person(2, "John", "Johnson", "johnLogin987", "man", "b", "b", new ExtraInfo());
    testPerson2.setExtraInfo(new ExtraInfo(2, "johnSkype", "London", "+1(23)555-55-55", 22, "v", testPerson2));

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

  public void tearDown() throws Exception {
    db.shutdown();
    sessionFactory.close();
  }

  public void testGetAllPersons() {
    List<Person> personList = personService.getAllPersons();
    Assert.assertEquals(personList.get(0).getName(), "Sergey");
    Assert.assertEquals(personList.get(1).getExtraInfo().getAge(), 12);
    Assert.assertEquals(personList.get(2).getExtraInfo().getEmail(), "dd@dd.com");
  }

  public void testSavePerson() {
  }

  public void testGetPerson() {
    Person testPerson = personService.getPerson(3);
    Assert.assertEquals(testPerson.getSurname(), "Sidorova");
    Assert.assertEquals(testPerson.getExtraInfo().getPhoneNumber(), "998877664");
  }

  public void testDeletePerson() {
  }

  public void testAuthorize() {
  }

  public void testUpdateExtraInfoOfPerson() throws PersonAlreadyExistException {
    personService.savePerson(testPerson2);
//        Person personWithNewExtraInfo =
//                new Person(testPerson2.getName(), testPerson2.getSurname(), testPerson2.getLogin());
//        personWithNewExtraInfo.setId(testPerson2.getId());
//        personWithNewExtraInfo.setExtraInfo(
//                new ExtraInfo("newJohn", "NewLondon", "+7-111-222-33-44", 99));
//
//        Assert.assertNotEquals(personWithNewExtraInfo, testPerson2);
//        Assert.assertEquals(personService.updateExtraInfoOfPerson(personWithNewExtraInfo), testPerson2);
//        personService.deletePerson(testPerson2.getId());
  }
}