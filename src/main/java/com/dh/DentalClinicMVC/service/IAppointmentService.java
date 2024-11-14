package com.dh.DentalClinicMVC.service;

import com.dh.DentalClinicMVC.dto.AppointmentDTO;
import com.dh.DentalClinicMVC.entity.Appointment;

import java.util.List;
import java.util.Optional;

public interface IAppointmentService {

    AppointmentDTO save(AppointmentDTO appointmentDTO);
    Optional<AppointmentDTO> findByid(Long id);
    void update(Appointment appointment);
    void delete (Long id);
    List<AppointmentDTO> findAll();

}
