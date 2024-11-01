package com.dh.DentalClinicMVC.controller;

import com.dh.DentalClinicMVC.model.Dentist;
import com.dh.DentalClinicMVC.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class DentistController {

    private DentistService dentistService;

    @Autowired
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

    // VAMOS A ACTUALIZAR LOS DATOS DE UN ODONTOLOGO
    @PutMapping
    public void update (@RequestBody Dentist dentist){
        dentistService.updateDentist(dentist);
    }

    // VAMOS A BORRAR UN ODONTOLOGO
    @DeleteMapping("/{id}")
    public  void  delete (@PathVariable Integer id) {
        dentistService.delete(id);
    }

    // VAMOS A LISTAR TODOS LOS ODONTOLOGOS
    @GetMapping
    public List<Dentist> findAll() {
        return dentistService.findAll();
    }
}
