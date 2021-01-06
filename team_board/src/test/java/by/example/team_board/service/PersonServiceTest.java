package by.example.team_board.service;

import by.example.team_board.entity.ExtraInfo;
import by.example.team_board.entity.Person;
import org.junit.BeforeClass;

import java.util.ArrayList;
import java.util.List;


public class PersonServiceTest {
    private static List<Person> personDAO;

    @BeforeClass
    public static void setUp() {
        personDAO = new ArrayList<>();
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();

        ExtraInfo extraInfo1 = new ExtraInfo();
        ExtraInfo extraInfo2 = new ExtraInfo();
        ExtraInfo extraInfo3 = new ExtraInfo();

        person1.setExtraInfo(extraInfo1);
        person2.setExtraInfo(extraInfo2);
        person3.setExtraInfo(extraInfo3);

        personDAO.add(person1);
        personDAO.add(person2);
        personDAO.add(person3);

    }

    public void testGetAllPersons() {

        // List<Person> personList =  personDAO.getAllPersons();
    }
}


