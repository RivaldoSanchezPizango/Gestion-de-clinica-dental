package com.dh.DentalClinicMVC.controller;

import com.dh.DentalClinicMVC.dto.AppointmentDTO;
import com.dh.DentalClinicMVC.entity.Appointment;
import com.dh.DentalClinicMVC.service.IAppointmentService;
import com.dh.DentalClinicMVC.service.IDentistService;
import com.dh.DentalClinicMVC.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class AppointmentController {

    private IAppointmentService appointmentService;
    private IDentistService dentistService;
    private IPatientService patientService;

    @Autowired
    public AppointmentController(IAppointmentService appointmentService, IDentistService dentistService, IPatientService patientService) {
        this.appointmentService = appointmentService;
        this.dentistService = dentistService;
        this.patientService = patientService;
    }

    // ESTE ENDPOINT CONSULTA TODOS LOS TURNOS
    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> findAll() {
        return ResponseEntity.ok(appointmentService.findAll());
    }

    //CREAR UN TURNO
    @PostMapping
    public ResponseEntity<AppointmentDTO> save(@RequestBody AppointmentDTO appointmentDTO) {
        ResponseEntity<AppointmentDTO> response;

        // chequeamos que existen el odontologo y el paciente
        if (dentistService.findByid(appointmentDTO.getDentist_id()).isPresent()
        && patientService.findByid(appointmentDTO.getPatient_id()).isPresent()) {
            // seteamos al ResponseEntity con el codigo 200 y le agregamos el turno como cuerpo de la respuesta
            response = ResponseEntity.ok(appointmentService.save(appointmentDTO));
        } else {
            // setear al ResponseEntity el codigo 400
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> findById(@PathVariable Long id) {
        Optional<AppointmentDTO> appointmentToLookFor = appointmentService.findByid(id);

        if (appointmentToLookFor.isPresent()) {
            return ResponseEntity.ok(appointmentToLookFor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //
    // PUTMAPPING

    @PutMapping
    public ResponseEntity<AppointmentDTO> update(@RequestBody  AppointmentDTO appointmentDTO) throws Exception {
        ResponseEntity<AppointmentDTO> response;
        // chequeamos ue existan el odontologo y el paciente
        if (dentistService.findByid(appointmentDTO.getDentist_id()).isPresent()
            && patientService.findByid(appointmentDTO.getPatient_id()).isPresent()){
            // ambos existen en la BD
            // seteamos al ResponseEntity con el codigo 200 y le agregamos el turno DTO como cuerpo de la respuesta
            response = ResponseEntity.ok(appointmentService.update(appointmentDTO));
        } else {
            // uno no existe, entonces bloqueamos la operacion
            // setear el ResponseEntity el codigo 400
            response = ResponseEntity.badRequest().build();
        }
        return response;
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id) {

        ResponseEntity<String> response;

        if (appointmentService.findByid(id).isPresent()) {
            appointmentService.delete(id);
            response = ResponseEntity.ok("Se elimino turno con ID " + id);
        } else {
            response = ResponseEntity.ok().body("no se puede eliminar un turno que no existe en la BD.");
        }
        return response;
    }

}
