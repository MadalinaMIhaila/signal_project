package data_management;

import static org.junit.jupiter.api.Assertions.*;

import com.data_management.DataReader;
import org.junit.jupiter.api.Test;

import com.data_management.DataStorage;
import com.data_management.PatientRecord;

import java.io.IOException;
import java.util.List;

class DataStorageTest {

    @Test
    void testAddAndGetRecords() throws IOException {
        // TODO Perhaps you can implement a mock data reader to mock the test data?
        // DataReader reader
        DataReader reader = new DataReader(){
            @Override
            public void readData (DataStorage storage){

                storage.addPatientData(1, 100.0, "WhiteBloodCells", 1714376789050L);
                storage.addPatientData(1, 200.0, "WhiteBloodCells", 1714376789051L);
            }
        };

        DataStorage storage = new DataStorage(reader);
        List<PatientRecord> records = storage.getRecords(1, 1714376789050L, 1714376789051L);
        assertEquals(2, records.size()); // Check if two records are retrieved
        assertEquals(100.0, records.get(0).getMeasurementValue()); // Validate first record
    }
}
