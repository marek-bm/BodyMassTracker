package pl.dietician.service;

import pl.dietician.model.Patient;

import java.util.List;

public interface PatientService {

    Patient findByPesel(String pesel);

    List<Patient> findAllByPeselContaining(String peselFragemnt);

    List<Patient> findAllByLastName(String lastName);

    Patient findById(long id);

    Patient save(Patient patient);
}
