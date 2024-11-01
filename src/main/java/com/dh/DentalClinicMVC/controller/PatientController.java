package com.dh.DentalClinicMVC.controller;

import com.dh.DentalClinicMVC.model.Patient;
import com.dh.DentalClinicMVC.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PatientController {

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // UN ENDPOINT QUE NOS PERMITA AGREGAR UN PACIENTE
    @PostMapping
    public Patient save (@RequestBody Patient patient) {
        return patientService.save(patient);
    }

    // UN ENDPOINT QUE NOS PERMITA ACTUALIZAR UN PACIENTE QUE YA ESTE REGISTRADO
    @PutMapping
    public void update(@RequestBody Patient patient) {
        patientService.update(patient);
    }

    @GetMapping
    public List<Patient> findAll () {
        return patientService.findAll();
    }

}
