package com.dh.DentalClinicMVC.controller;

import com.dh.DentalClinicMVC.model.Dentist;
import com.dh.DentalClinicMVC.service.DentistService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/odontologos")
public class DentistController {

    private DentistService dentistService;

    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    // UN ENDPOINT QUE NOS PERMITA CONSULTAR ODONTOLOGOS POR ID
    // localhost:8080/odontologos/{id}
    @GetMapping ("/{id}")
    public Dentist findById(@PathVariable  Integer id) {
        return dentistService.findById(id);
    }


    // UN ENDPOINT - VAMOS A GUARDAR UN NUEVO ODONTOLOGO EN LA BD
    @PostMapping
    public Dentist save (@RequestBody Dentist dentist) {
      return dentistService.save(dentist);
    }

    //
}
