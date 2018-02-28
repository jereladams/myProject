package com.myRide.persistence;

import com.myRide.entity.Car;
import com.myRide.entity.Part;
import com.myRide.entity.Repair;
import com.myRide.testUtils.Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PartTest {

    GenericDao<Part>  partDao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {

        partDao = new GenericDao(Part.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies gets all parts successfully.
     */
    @Test
    void getAllPartsSuccess() {
        List<Part> parts = partDao.getAll();
        assertNotNull(parts);
        assertEquals(1, parts.size());
    }

    /**
     * Verifies a part is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        //Get Repair
        GenericDao<Repair>  repairDao = new GenericDao(Repair.class);
        Repair repair = repairDao.getById(1);

        //Create TimeStamp
        Timestamp timestamp =  Timestamp.valueOf("2018-01-01 12:00:00");

        Double price = 100.00;

        //Create Test Part
        Part testPart = new Part(1,repair,"Brakes pads","Raybestos","123-456","5 year replacement","Autozone",price,"Gold Premium",timestamp,timestamp);

        //Get Existing Part
        Part retrievedPart = partDao.getById(1);
        assertNotNull(retrievedPart);

        //Compare Parts
        assertEquals(testPart,retrievedPart);
    }

    /**
     * Verify successful insert of a part
     */
    @Test
    void insertSuccess() {
        int insertedPartId;

        //Get Repair
        GenericDao<Repair>  repairDao = new GenericDao(Repair.class);
        Repair repair = repairDao.getById(1);

        //Create TimeStamp
        Timestamp timestamp =  Timestamp.valueOf("2018-01-01 12:00:00");

        Double price = 100.00;

        //Create Inserted Part
        Part insertedPart = new Part(repair,"Brake pads","Raybestos","123-456","5 year replacement","Autozone",price,"Gold Premium",timestamp,timestamp);

        //Save Inserted Part
        insertedPartId = partDao.insert(insertedPart);

        //Get Saved Part
        Part retrievedPart = partDao.getById(insertedPartId);
        assertNotNull(retrievedPart);

        //Compare Parts
        assertEquals(insertedPart,retrievedPart);
    }

    /**
     * Verify successful delete of part
     *
     */
    @Test
    void deleteSuccess() {
        partDao.delete(partDao.getById(1));
        assertNull(partDao.getById(1));
    }

    /**
     * Verify successful update of part
     */
    @Test
    void updateSuccess() {
        String partName = "Brake calipers";
        Part partToUpdate = partDao.getById(1);
        partToUpdate.setPartName(partName) ;
        partDao.saveOrUpdate(partToUpdate);
        Part retrievedPart = partDao.getById(1);
        assertEquals(partToUpdate, retrievedPart);
    }

}


