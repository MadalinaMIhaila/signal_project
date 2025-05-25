package com.cardio_generator.generators;

import java.util.Random;

import com.cardio_generator.outputs.OutputStrategy;

/**
 * The {@code AlertGenerator} class generates alerts
 * for patients in a cardiovascular monitoring system.
 * <p> Alerts can be triggered or resolved. When an alert is triggered,
 * there's a high probability it will be resolved.</p>
 */
public class AlertGenerator implements PatientDataGenerator {

    //Changed constant name
    public static final Random RANDOM_GENERATOR = new Random();
    // Changed field name (LowerCase)
    private boolean[] alertStates; // false = resolved, true = pressed

    /**
     * Constructor that creates alerts for the number of patients
     * @param patientCount The number of patients
     */

    public AlertGenerator(int patientCount) {
        alertStates = new boolean[patientCount + 1];
    }

    /**
     * Based on random probabilities this method generates alerts for
     * a specific patient.
     *
     * @param patientId The specific patient
     * @param outputStrategy It handles the output based on the
     *                       generated alerts
     */
    @Override
    public void generate(int patientId, OutputStrategy outputStrategy) {
        try {
            if (alertStates[patientId]) {
                if (RANDOM_GENERATOR.nextDouble() < 0.9) { // 90% chance to resolve
                    alertStates[patientId] = false;
                    // Output the alert
                    outputStrategy.output(patientId, System.currentTimeMillis(), "Alert", "resolved");
                }
            } else {
                //variable Lambda changed to lambda (LowerCamelCase)
                double lambda = 0.1; // Average rate (alerts per period), adjust based on desired frequency
                double p = -Math.expm1(-lambda); // Probability of at least one alert in the period
                boolean alertTriggered = RANDOM_GENERATOR.nextDouble() < p;

                if (alertTriggered) {
                    alertStates[patientId] = true;
                    // Output the alert
                    outputStrategy.output(patientId, System.currentTimeMillis(), "Alert", "triggered");
                }
            }
        } catch (Exception e) {
            System.err.println("An error occurred while generating alert data for patient " + patientId);
            e.printStackTrace();
        }
    }
}
