package kg.ksucta.kgiai.datenbank2.ig1_15.murat.test;

import kg.ksucta.kgiai.datenbank2.ig1_15.murat.dao.Repository;
import kg.ksucta.kgiai.datenbank2.ig1_15.murat.dao.repository.UserRepository;
import kg.ksucta.kgiai.datenbank2.ig1_15.murat.dao.repository.impl.UserRepositoryImpl;
import kg.ksucta.kgiai.datenbank2.ig1_15.murat.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class UserRepositoryImplTest {

    UserRepository repository;

    @Before
    public void setUp() throws Exception {
        repository = UserRepositoryImpl.getInstance();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findOne() throws Exception {
        User user = repository.findOne(1L);
        assertNotNull(user);
        assertEquals(1l, (long)user.getId());
        assertEquals("Мурат", user.getName());
    }

    @Test
    public void findAll() throws Exception {
        List<User> users = repository.findAll();
        assertNotNull(users);
    }

    @Test
    public void save() throws Exception {
        repository.save(new User("sldkfj", "eiw", "eoiwfj"));
        Stream<User> sldkfj = repository.findAll().stream().filter((s) -> s.getName().equals("sldkfj"));
        assertTrue(sldkfj.count() >= 1);
    }

    @Test
    public void save1() throws Exception {
    }

}