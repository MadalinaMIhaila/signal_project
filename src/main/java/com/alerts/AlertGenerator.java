package com.alerts;

import com.data_management.DataStorage;
import com.data_management.Patient;

/**
 * Monitors patient data and generates alerts when predefined conditions are met.
 *
 * <p>This class relies on a {@link DataStorage} instance to access patient data
 * and evaluate it against specific health criteria.
 */
public class AlertGenerator {
    private DataStorage dataStorage;

    /**
     * Constructs an {@code AlertGenerator} with a specified {@code DataStorage}.
     *
     * @param dataStorage the data storage system that provides access to patient
     *                    data
     */
    public AlertGenerator(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    /**
     * Evaluates the specified patient's data for alert conditions.
     *
     * <p>If any alert conditions are met, the {@link #triggerAlert} method is invoked.
     * This method should define the specific conditions under which an alert will be triggered.
     *
     * @param patient the patient data to evaluate for alert conditions
     */
    public void evaluateData(Patient patient) {
        // Implementation goes here
    }

    /**
     * Triggers an alert for the monitoring system.
     *
     * <p>This method can be extended to notify medical staff, log the alert, or perform other actions.
     * The method assumes that the alert object is fully formed when passed as an argument.
     *
     * @param alert the alert object containing details about the alert condition
     */
    private void triggerAlert(Alert alert) {
        // Implementation might involve logging the alert or notifying staff
    }
}
