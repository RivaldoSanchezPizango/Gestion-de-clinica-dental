package com.dh.DentalClinicMVC.controller;

import com.dh.DentalClinicMVC.model.Dentist;
import com.dh.DentalClinicMVC.model.Patient;
import com.dh.DentalClinicMVC.service.impl.DentistServiceimpl;
import com.dh.DentalClinicMVC.service.impl.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/inicio")
public class IndexController {

    private PatientService patientService;

    private DentistServiceimpl dentistServiceimpl;

    public IndexController(PatientService patientService, DentistServiceimpl dentistServiceimpl) {
        this.patientService = patientService;
        this.dentistServiceimpl = dentistServiceimpl;
    }

    @GetMapping
    public String findPatientByEmail (Model model,@RequestParam("email") String email, @RequestParam("id") Integer id) {

        Patient patient = patientService.findByEmail(email);
        Dentist dentist = dentistServiceimpl.findById(id);
        // BUSCAMOS AL ODONTOLOGO CON ID
        model.addAttribute("name", patient.getName());
        model.addAttribute("lastName", patient.getLastName());

        // AGREGAR LA VISTA QUE SE CORRESPONDE CON ODONTOLOGO
        model.addAttribute("nameDentist", dentist.getName());
        model.addAttribute("lastNameDentist", dentist.getLastName());
        model.addAttribute("registration", dentist.getRegistration());

        return "index";
    }

}
