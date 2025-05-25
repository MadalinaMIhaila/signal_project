package com.cardio_generator.generators;

import com.cardio_generator.outputs.OutputStrategy;

/**
 * Interface to generate data for patients.
 */

public interface PatientDataGenerator {
    void generate(int patientId, OutputStrategy outputStrategy);
}
