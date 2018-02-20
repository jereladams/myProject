package com.myRide.persistence;

import com.myRide.entity.Car;
import com.myRide.entity.User;
import com.myRide.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    GenericDao<Car>  carDao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {

        carDao = new GenericDao(Car.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies gets all users successfully.
     */
    @Test
    void getAllUsersSuccess() {
        List<Car> cars = carDao.getAll();
        assertNotNull(cars);
        assertEquals(1, cars.size());
    }

    /**
     * Verifies a user is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        Car retrievedCar = carDao.getById(1);
        assertNotNull(retrievedCar);
        assertEquals("Jeep",retrievedCar.getMake());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        GenericDao<User>  userDao = new GenericDao(User.class);

        User user = userDao.getById(1);

        Car newCar = new Car(user,"2003","Ford","Taurus","12345");

        int id = carDao.insert(newCar);
        assertNotEquals(0,id);
        Car insertedCar = carDao.getById(id);
        assertNotNull(insertedCar);
        assertEquals(newCar,insertedCar);
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
        carDao.delete(carDao.getById(1));
        assertNull(carDao.getById(1));
    }

    /**
     * Verify successful update of user
     */
    @Test
    void updateSuccess() {
        String year = "2010";
        Car carToUpdate = carDao.getById(1);
        carToUpdate.setYear(year);
        carDao.saveOrUpdate(carToUpdate);
        Car retrievedCar = carDao.getById(1);
        assertEquals(carToUpdate, retrievedCar);
    }

}


