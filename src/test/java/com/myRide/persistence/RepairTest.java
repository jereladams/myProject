package com.myRide.persistence;

import com.myRide.entity.Car;
import com.myRide.entity.Repair;
import com.myRide.testUtils.Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RepairTest {

    GenericDao<Repair>  repairDao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {

        repairDao = new GenericDao(Repair.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies gets all repairs successfully.
     */
    @Test
    void getAllRepairsSuccess() {
        List<Repair> repairs = repairDao.getAll();
        assertNotNull(repairs);
        assertEquals(1, repairs.size());
    }

    /**
     * Verifies a repair is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        //Get User
        GenericDao<Car>  carDao = new GenericDao(Car.class);
        Car car = carDao.getById(1);

        //Create TimeStamp
        Timestamp timestamp =  Timestamp.valueOf("2018-01-01 12:00:00");
        LocalDate localDate = LocalDate.parse("2018-01-01");
        Double laborCost = 300.00;
        int currentMileage = 45000;

        //Create Test Repair
        Repair testRepair = new Repair(1,car,localDate,"123-456","Midas",laborCost,currentMileage,"5 years parts and labor","Brakes","Replaced rotors and pads",timestamp,timestamp);

        //Get Existing Repair
        Repair retrievedRepair = repairDao.getById(1);
        assertNotNull(retrievedRepair);

        //Compare Repairs
        assertEquals(testRepair,retrievedRepair);
    }

    /**
     * Verify successful insert of a repair
     */
    @Test
    void insertSuccess() {
        int insertedRepairId;

        //Get Car
        GenericDao<Car>  carDao = new GenericDao(Car.class);
        Car car = carDao.getById(1);

        //Create TimeStamp
        Timestamp timestamp =  Timestamp.valueOf("2018-01-01 12:00:00");
        LocalDate localDate = LocalDate.now();
        Double laborCost = 100.00;
        int currentMileage = 50000;

        //Create Inserted Repair
        //Create Test Repair
        Repair insertedRepair = new Repair(car,localDate,"123-456","Midas",laborCost,currentMileage,"5 years parts and labor","Brakes","Replaced rotors and pads",timestamp,timestamp);

        //Save Inserted Repair
        insertedRepairId = repairDao.insert(insertedRepair);

        //Get Saved Repair
        Repair retrievedRepair = repairDao.getById(insertedRepairId);
        assertNotNull(retrievedRepair);

        //Compare Repairs
        assertEquals(insertedRepair,retrievedRepair);
    }

    /**
     * Verify successful delete of repair and parts
     *
     */
    @Test
    void deleteSuccess() {
        repairDao.delete(repairDao.getById(1));
        assertNull(repairDao.getById(1));

        //  TODO: add testing for deleting parts

    }

    /**
     * Verify successful update of repair
     */
    @Test
    void updateSuccess() {
        String invoiceNumber = "111-222-333";
        Repair repairToUpdate = repairDao.getById(1);
        repairToUpdate.setInvoiceNumber(invoiceNumber);
        repairDao.saveOrUpdate(repairToUpdate);
        Repair retrievedRepair = repairDao.getById(1);
        assertEquals(repairToUpdate, retrievedRepair);
    }

}


