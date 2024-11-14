package com.dh.DentalClinicMVC.service.impl;

import com.dh.DentalClinicMVC.dto.AppointmentDTO;
import com.dh.DentalClinicMVC.entity.Appointment;
import com.dh.DentalClinicMVC.entity.Dentist;
import com.dh.DentalClinicMVC.entity.Patient;
import com.dh.DentalClinicMVC.repository.IAppointmentRepository;
import com.dh.DentalClinicMVC.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService implements IAppointmentService {

    private IAppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(IAppointmentRepository iAppointmentRepository) {
        this.appointmentRepository = iAppointmentRepository;
    }

    @Override
    public AppointmentDTO save(AppointmentDTO appointmentDTO) {
        // mapear nuestras entidades como DTO manualmente(existen librerias que lo hacen automatica)
        // instanciar una entidad de turno
        Appointment appointmentEntity = new Appointment();

        // instanciamos un paciente
        Patient patientEntity = new Patient();
        patientEntity.setId(appointmentDTO.getPatient_id());

        // instanciamos un odontologo
        Dentist dentistEntity = new Dentist();
        dentistEntity.setId(appointmentDTO.getDentist_id());

        // seteamos el paciente y el odontologo a nuestra entidad turno
        appointmentEntity.setPatient(patientEntity);
        appointmentEntity.setDentist(dentistEntity);

        // convertir el string del turno DTO que es la fecha a un
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(appointmentDTO.getDate(), formatter);

        // seteamos la fecha
        appointmentEntity.setDate(date);

        // persistir en la BD
        appointmentRepository.save(appointmentEntity);

        // vamos a trabajar con el DTO que debemos devolver
        // vamos a generar una instancia de turno DTO
        AppointmentDTO appointmentDTOToReturn = new AppointmentDTO();

        // seteamos ls datos de la entidad que persistimos
        appointmentDTOToReturn.setId(appointmentEntity.getId());
        appointmentDTOToReturn.setDate(appointmentEntity.getDate().toString());
        appointmentDTOToReturn.setDentist_id(appointmentEntity.getDentist().getId());
        appointmentDTOToReturn.setPatient_id(appointmentEntity.getPatient().getId());

        return appointmentDTOToReturn;
    }

    @Override
    public Optional<Appointment> findByid(Long id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public void update(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public void delete(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public List<AppointmentDTO> findAll() {
        // vamos a traernos las entidades dela BD y la vamos a guardar en una lista
        List<Appointment> appointments = appointmentRepository.findAll();

        // vamos a crear una lista vacia de turnos DTO
        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();

        // recorremos la lista de entidades de turno para luego
        // guardarlas en la lista de tunos DTO
        for (Appointment appointment : appointments) {
            appointmentDTOS.add(new AppointmentDTO(appointment.getId(),appointment.getPatient().getId(),
                    appointment.getDentist().getId(), appointment.getDate().toString()));
        }
        return appointmentDTOS;
    }
}

