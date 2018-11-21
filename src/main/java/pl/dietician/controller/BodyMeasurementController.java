package pl.dietician.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dietician.model.BodyMeasurement;
import pl.dietician.service.BodyMeasurementService;
import pl.dietician.service.PatientService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class BodyMeasurementController {

    @Autowired
    PatientService patientService;

    @Autowired
    BodyMeasurementService bodyMeasurementService;

    @RequestMapping(value = "/save-data", method = RequestMethod.POST)
    public String saveDateFromForm(@Valid BodyMeasurement bodyData,
                                   BindingResult result,
                                   HttpServletRequest request){

        if(result.hasErrors()){
            return "patient-details";
        }

        bodyMeasurementService.save(bodyData);

        String referer = request.getHeader("Referer");

        return "redirect:"+ referer;
    }

}
