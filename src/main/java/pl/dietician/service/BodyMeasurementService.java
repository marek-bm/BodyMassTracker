package pl.dietician.service;

import pl.dietician.model.BodyMeasurement;
import pl.dietician.model.Patient;

import java.util.List;

public interface BodyMeasurementService {

    List<BodyMeasurement> findAllByPatient(Patient patient);

    List<BodyMeasurement> findAllByPatientId(long patientId);

    BodyMeasurement save(BodyMeasurement measurement);
}
