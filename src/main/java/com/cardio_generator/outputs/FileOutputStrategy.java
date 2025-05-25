package com.cardio_generator.outputs;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The {@code FileOutputStrategy} class implements the
 * {@code OutputStrategy} interface to put the output data into files.
 */

// Changed file name to FileOutputStrategy (UpperCamelCase)
public class FileOutputStrategy implements OutputStrategy {

    //Changed the string variable name to baseDirectory (LowerCamelCase)
    private String baseDirectory;

    //Changed the variable name to fileMap (Rules common to all identifiers)
    public final ConcurrentHashMap<String, String> fileMap = new ConcurrentHashMap<>();

    public FileOutputStrategy(String baseDirectory) {

        this.baseDirectory = baseDirectory;
    }

    /**
     * Method to output the generated data into a file.
     *
     * @param patientId The specific patient
     * @param timestamp The timestamp of the patient's data
     * @param label The label
     * @param data The output data
     */

    @Override
    public void output(int patientId, long timestamp, String label, String data) {
        try {
            // Create the directory
            Files.createDirectories(Paths.get(baseDirectory));
        } catch (IOException e) {
            System.err.println("Error creating base directory: " + e.getMessage());
            return;
        }
        // Set the FilePath variable
        //Changed variable name to filePath (LowerCamelCase)
        String filePath = fileMap.computeIfAbsent(label, k -> Paths.get(baseDirectory, label + ".txt").toString());

        // Write the data to the file
        try (PrintWriter out = new PrintWriter(
                Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.CREATE, StandardOpenOption.APPEND))) {
            out.printf("Patient ID: %d, Timestamp: %d, Label: %s, Data: %s%n", patientId, timestamp, label, data);
        } catch (Exception e) {
            System.err.println("Error writing to file " + filePath + ": " + e.getMessage());
        }
    }
}