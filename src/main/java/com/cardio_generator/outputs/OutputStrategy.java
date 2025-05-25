package com.cardio_generator.outputs;

/**
 * Interface to output the data.
 */

public interface OutputStrategy {
    void output(int patientId, long timestamp, String label, String data);
}
