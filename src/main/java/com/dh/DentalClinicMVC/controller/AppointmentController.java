package com.dh.DentalClinicMVC.controller;

import com.dh.DentalClinicMVC.model.Appointment;
import com.dh.DentalClinicMVC.service.AppointmentService;
import com.dh.DentalClinicMVC.service.DentistService;
import com.dh.DentalClinicMVC.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class AppointmentController {

    private AppointmentService appointmentService;
    private DentistService dentistService;
    private PatientService patientService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, DentistService dentistService, PatientService patientService) {
        this.appointmentService = appointmentService;
        this.dentistService = dentistService;
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> findAll() {
        return ResponseEntity.ok(appointmentService.findAll());
    }

    @PostMapping
    public ResponseEntity<Appointment> save(@RequestBody Appointment appointment) {

        ResponseEntity<Appointment> response;

        // chequeamos que existen el odontologo y el paciente
        if (dentistService.findById(appointment.getDentist().getId()) != null
        && patientService.findById(appointment.getPatient().getId()) !=null) {
            // seteamos al ResponseEntity con el codigo 200 y le agregamos el turno como cuerpo de la respuesta
            response = ResponseEntity.ok(appointmentService.save(appointment));
        } else {
            // setear al ResponseEntity el codigo 400
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }
}
