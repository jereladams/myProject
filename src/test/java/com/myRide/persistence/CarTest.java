package com.myRide.persistence;

import com.myRide.entity.Car;
import com.myRide.entity.User;
import com.myRide.testUtils.Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
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
     * Verifies a car is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        //Get User
        GenericDao<User>  userDao = new GenericDao(User.class);
        User user = userDao.getById(1);

        //Create TimeStamp
        Timestamp timestamp =  Timestamp.valueOf("2018-01-01 12:00:00");

        //Create Test Car
        Car testCar = new Car(1,user,"2001","Jeep","Grand Cherokee","12345678901234567",timestamp,timestamp);

        //Get Existing Car
        Car retrievedCar = carDao.getById(1);
        assertNotNull(retrievedCar);

        //Compare Cars
        assertEquals(testCar,retrievedCar);
    }

    /**
     * Verify successful insert of a car
     */
    @Test
    void insertSuccess() {
        int insertedCarId;

        //Get User
        GenericDao<User>  userDao = new GenericDao(User.class);
        User user = userDao.getById(1);

        //Create TimeStamp
        Timestamp timestamp =  Timestamp.valueOf("2018-01-01 12:00:00");

        //Create Inserted Car
        Car insertedCar = new Car(user,"2016","Honda","Civic","3335678901244444",timestamp,timestamp);

        //Save Inserted Car
        insertedCarId = carDao.insert(insertedCar);

        //Get Saved Car
        Car retrievedCar = carDao.getById(insertedCarId);
        assertNotNull(retrievedCar);

        //Compare Cars
        assertEquals(insertedCar,retrievedCar);
     }

    /**
     * Verify successful delete of car, repairs and parts
     *
     */
    @Test
    void deleteSuccess() {
        carDao.delete(carDao.getById(1));
        assertNull(carDao.getById(1));

    //  TODO: add testing for deleting repairs & parts

    }

    /**
     * Verify successful update of car
     */
    @Test
    void updateSuccess() {
        String year = "2017";
        Car carToUpdate = carDao.getById(1);
        carToUpdate.setYear(year);
        carDao.saveOrUpdate(carToUpdate);
        Car retrievedCar = carDao.getById(1);
        assertEquals(carToUpdate, retrievedCar);
    }

}


