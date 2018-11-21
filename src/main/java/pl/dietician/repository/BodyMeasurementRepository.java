package pl.dietician.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dietician.model.BodyMeasurement;
import pl.dietician.model.Patient;

import java.util.List;

@Repository
public interface BodyMeasurementRepository extends JpaRepository<BodyMeasurement, Long> {

    List<BodyMeasurement> findAllByPatient(Patient patient);

    List<BodyMeasurement> findAllByPatientId(long patientId);

    BodyMeasurement save(BodyMeasurement measurement);
}
