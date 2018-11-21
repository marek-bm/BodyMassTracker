package pl.dietician.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dietician.model.BodyMeasurement;
import pl.dietician.model.Patient;
import pl.dietician.repository.BodyMeasurementRepository;
import pl.dietician.service.BodyMeasurementService;

import java.util.List;

@Service
public class BodyMeasurementServiceImpl implements BodyMeasurementService {

    @Autowired
    BodyMeasurementRepository bodyMeasurementRepository;


    @Override
    public List<BodyMeasurement> findAllByPatient(Patient patient) {
        return bodyMeasurementRepository.findAllByPatient(patient);
    }

    @Override
    public List<BodyMeasurement> findAllByPatientId(long patientId) {
        return bodyMeasurementRepository.findAllByPatientId(patientId);
    }

    @Override
    public BodyMeasurement save(BodyMeasurement measurement) {
        return bodyMeasurementRepository.saveAndFlush(measurement);
    }
}
