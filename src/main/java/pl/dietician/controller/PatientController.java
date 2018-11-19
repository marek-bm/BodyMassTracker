package pl.dietician.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dietician.model.Patient;
import pl.dietician.service.PatientService;

import javax.validation.Valid;

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

    @RequestMapping (value = "/find", method = RequestMethod.GET)
    public String loadPatient(Model model, long id){

        Patient patient=patientService.findById(id);

        model.addAttribute("patient", patient);

        return "patient-view";
    }
}
