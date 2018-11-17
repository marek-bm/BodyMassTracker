package pl.dietician.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dietician.error.PatientNotFoundException;
import pl.dietician.model.Patient;
import pl.dietician.repository.PatientRepository;
import pl.dietician.service.PatientService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Patient findByPesel(String pesel) {

        Patient patient=new Patient();

        try{
            patient=patientRepository.findByPesel(pesel);
            return patient;
        }
        catch (Exception e){
            if (patient==null){
                throw new PatientNotFoundException("Patient with given PESEL was NOT FOUND "+ pesel, e);
            }
        }
        return null;
    }

    @Override
    public List<Patient> findAllByPeselContaining(String peselFragemnt) {

        List<Patient> patients=new ArrayList<>();

        try{
            patients=patientRepository.findAllByPeselContaining(peselFragemnt);
            return patients;
        }
        catch (Exception e){
            if (patients==null || patients.isEmpty()){
                throw new PatientNotFoundException("Patients with given PESEL were NOT FOUND "+ peselFragemnt, e);
            }
        }
        return null;
    }


    @Override
    public List<Patient> findAllByLastName(String lastName) {

        List<Patient> patients=new ArrayList<>();

        try{
            patients=patientRepository.findAllByLastName(lastName);
            return patients;
        }
        catch (Exception e){
            if (patients==null || patients.isEmpty()){
                throw new PatientNotFoundException("Patients with given LAST NAME were NOT FOUND "+ lastName, e);
            }
        }
        return null;
    }

    @Override
    public Patient findById(long id) {
        Patient patient=new Patient();

        try{
            patient=patientRepository.findById(id);
            return patient;
        }
        catch (Exception e){
            if (patient==null){
                throw new PatientNotFoundException("Patient with given ID was NOT FOUND "+ id, e);
            }
        }
        return null;
    }
}
