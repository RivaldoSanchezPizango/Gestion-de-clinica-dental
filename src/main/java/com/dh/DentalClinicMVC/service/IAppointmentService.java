package com.dh.DentalClinicMVC.service;

import com.dh.DentalClinicMVC.model.Appointment;
import com.dh.DentalClinicMVC.model.Dentist;

import java.util.List;
import java.util.Optional;

public interface IAppointmentService {

    Appointment save(Appointment appointment);
    Optional<Appointment> findByid(Long id);
    void update(Appointment appointment);
    void delete (Long id);
    List<Appointment> findAll();

}
