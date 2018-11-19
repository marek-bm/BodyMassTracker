package pl.dietician.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.dietician.model.Patient;
import pl.dietician.service.PatientService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PatientController {

    @Autowired
    PatientService patientService;

    @RequestMapping("/patients")
    public String patientsZone(){
        return "patients-zone";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerNewPatient(Model model){

        Patient patient=new Patient();

        model.addAttribute("patient", patient);

        return "forms/register-patient";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String finalizeRegistaration(@Valid Patient patient, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "forms/register-patient";
        }

        patientService.save(patient);

        return "index";
    }

    @RequestMapping (value = "/find-by-name", method = RequestMethod.POST)
    public String loadPatientByName(Model model, @RequestParam String lastName){

        List<Patient> patients=patientService.findAllByLastName(lastName);

        model.addAttribute("patients", patients);

        model.addAttribute("query", lastName);

        return "patient-search-result";
    }


    @RequestMapping (value = "/find-by-pesel", method = RequestMethod.POST)
    public String loadPatientByPesel(Model model, @RequestParam String pesel){

        List<Patient> patients=patientService.findAllByPeselContaining(pesel);

        model.addAttribute("patients", patients);

        model.addAttribute("query", pesel);

        return "patient-search-result";
    }
}