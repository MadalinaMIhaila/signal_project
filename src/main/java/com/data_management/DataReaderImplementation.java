package com.data_management;

import java.io.IOException;

/**
 * The {@code DataReaderImplementation} calss implements the {@code DataReader}
 * interface
 */

public class DataReaderImplementation implements DataReader {

    private String filePath;

    public DataReaderImplementation(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void readData(DataStorage dataStorage) throws IOException {

    }

}
