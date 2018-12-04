package pl.dietician.controller;

import com.google.gson.Gson;
import org.hibernate.validator.constraints.pl.PESEL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.dietician.model.BodyMeasurement;
import pl.dietician.model.Patient;
import pl.dietician.service.BodyMeasurementService;
import pl.dietician.service.PatientService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    BodyMeasurementService bodyMeasurementService;

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

        return "home";
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

    @RequestMapping (value = "/edit-patient/{id}", method = RequestMethod.GET)
    public String editPatient(@PathVariable long id, Model model){

        Patient patient=patientService.findById(id);

        model.addAttribute("patient", patient);

        return "forms/edit-patient";
    }

    @RequestMapping (value = "/show-patient/{id}", method = RequestMethod.GET)
    public String showPatientDetails(@PathVariable long id, Model model){

        Patient patient=patientService.findById(id);

        List<BodyMeasurement> patientHistory=bodyMeasurementService.findAllByPatient(patient);

        Gson gson=new Gson();

        String gsonString=gson.toJson(patientHistory);

        BodyMeasurement bodyData=new BodyMeasurement();

        bodyData.setPatient(patient);

        model.addAttribute("patient", patient);

        model.addAttribute("bodyDataEmptyObj", bodyData);

        model.addAttribute("history", patientHistory);

        return "patient-details";
    }



    @RequestMapping (value = "/api/show-patient/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String showPatientDetailsJSON(@PathVariable long id){

        Patient patient=patientService.findById(id);

        List<BodyMeasurement> patientHistory=bodyMeasurementService.findAllByPatient(patient);

        Gson gson=new Gson();

        String gsonString=gson.toJson(patientHistory);

        return gsonString;
    }

}
