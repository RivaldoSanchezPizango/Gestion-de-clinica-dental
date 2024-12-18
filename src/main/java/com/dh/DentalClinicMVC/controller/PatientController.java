package com.dh.DentalClinicMVC.controller;

import com.dh.DentalClinicMVC.entity.Patient;
import com.dh.DentalClinicMVC.exception.ResourceNotFoundException;
import com.dh.DentalClinicMVC.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PatientController {

    private IPatientService patientService;
    @Autowired
    public PatientController(IPatientService patientService) {
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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id) throws ResourceNotFoundException {
        patientService.delete(id);
            return ResponseEntity.ok("Se elimino el paciente con id: " + id);
    }

}
