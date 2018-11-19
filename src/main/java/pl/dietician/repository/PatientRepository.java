package pl.dietician.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dietician.model.Patient;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository <Patient, Long> {

    Patient findByPesel(String pesel);

    List<Patient> findAllByPeselContaining(String peselFragemnt);

    List<Patient> findAllByLastName(String lastName);

    List<Patient> findAllByLastNameContaining(String lastName);

    Patient findById(long id);
}
