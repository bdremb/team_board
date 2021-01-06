package by.example.team_board.service;

import by.example.team_board.dao.PersonDAOImplTest;
import by.example.team_board.entity.Person;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceTest {
    private PersonDAOImplTest personDAO;


    @BeforeClass
    public static void setUp() {

    }

    @Test
    @Transactional
    public void testGetAllPersons() {
        List<Person> personList = personDAO.getAllPersons();
        Assert.assertEquals(personList, null);
       // Assert.assertEquals(expected, actual);  //ожидаемое, актуальное значения
    }
}


