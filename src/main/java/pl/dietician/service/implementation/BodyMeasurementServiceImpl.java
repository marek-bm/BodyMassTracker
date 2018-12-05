package pl.dietician.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dietician.model.BodyMeasurement;
import pl.dietician.model.Patient;
import pl.dietician.repository.BodyMeasurementRepository;
import pl.dietician.service.BodyMeasurementService;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class BodyMeasurementServiceImpl implements BodyMeasurementService {

    @Autowired
    BodyMeasurementRepository bodyMeasurementRepository;


    @Override
    public List<BodyMeasurement> findAllByPatient(Patient patient) {

        List<BodyMeasurement> searchResult=bodyMeasurementRepository.findAllByPatient(patient);

        searchResult.sort((BodyMeasurement b1, BodyMeasurement b2)-> (b1.getDateOfInspection().compareTo(b1.getDateOfInspection())));

        return searchResult;
    }

    @Override
    public List<BodyMeasurement> findAllByPatientId(long patientId) {

        List<BodyMeasurement> searchResult=bodyMeasurementRepository.findAllByPatientId(patientId);

        searchResult.sort((BodyMeasurement b1, BodyMeasurement b2)-> (b1.getDateOfInspection().compareTo(b1.getDateOfInspection())));

        return searchResult;
    }

    @Override
    public BodyMeasurement save(BodyMeasurement measurement) {
        return bodyMeasurementRepository.saveAndFlush(measurement);
    }
}
