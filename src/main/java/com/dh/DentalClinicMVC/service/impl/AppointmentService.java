package com.dh.DentalClinicMVC.service.impl;

import com.dh.DentalClinicMVC.model.Appointment;
import com.dh.DentalClinicMVC.repository.IAppointmentRepository;
import com.dh.DentalClinicMVC.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.ldap.PagedResultsControl;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService implements IAppointmentService {

    private IAppointmentRepository iAppointmentRepository;

    @Autowired
    public AppointmentService(IAppointmentRepository iAppointmentRepository) {
        this.iAppointmentRepository = iAppointmentRepository;
    }

    @Override
    public Appointment save(Appointment appointment) {
        return iAppointmentRepository.save(appointment);
    }

    @Override
    public Optional<Appointment> findByid(Long id) {
        return iAppointmentRepository.findById(id);
    }

    @Override
    public void update(Appointment appointment) {
        iAppointmentRepository.save(appointment);
    }

    @Override
    public void delete(Long id) {
        iAppointmentRepository.deleteById(id);
    }

    @Override
    public List<Appointment> findAll() {
        return iAppointmentRepository.findAll();
    }
}

