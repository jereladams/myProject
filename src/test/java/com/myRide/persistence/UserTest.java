package com.myRide.persistence;

import com.myRide.entity.User;
import com.myRide.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    GenericDao<User>  userDao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        userDao = new GenericDao(User.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies gets all users successfully.
     */
    @Test
    void getAllUsersSuccess() {
        List<User> users = userDao.getAll();
        assertNotNull(users);
        assertEquals(3, users.size());
    }

    /**
     * Verifies a user is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = userDao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("aaa",retrievedUser.getPassword());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {
        User newUser = new User("ddd@email.com", "ddd");
        int id = userDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = userDao.getById(id);
        assertNotNull(insertedUser);
        assertEquals(insertedUser,newUser);
    }

    /**
     * Verify successful insert of a user
     */

    /**
    @Test
    void insertWithBookSuccess() {
        User newUser = new User("test@email.com", "password");
        Book book = new Book( "Book 1", newUser, "123-4-56789",   1973);
        newUser.addBook(book);
        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = dao.getById(id);
        assertNotNull(insertedUser);
        assertEquals(newUser, insertedUser);
        assertNotNull(insertedUser.getBooks());
        assertEquals(1, insertedUser.getBooks().size());
    }
    */

    /**
     * Verify successful delete of user & books
     *
     * Note: added some extra tests for practice
     */
    @Test
    void deleteSuccess() {
        userDao.delete(userDao.getById(3));
        assertNull(userDao.getById(3));
    }

    /**
     * Verify successful update of user
     */
    @Test
    void updateSuccess() {
        String password = "abc";
        User userToUpdate = userDao.getById(3);
        userToUpdate.setPassword(password) ;
        userDao.saveOrUpdate(userToUpdate);
        User retrievedUser = userDao.getById(3);
        assertEquals(userToUpdate, retrievedUser);
    }

}

