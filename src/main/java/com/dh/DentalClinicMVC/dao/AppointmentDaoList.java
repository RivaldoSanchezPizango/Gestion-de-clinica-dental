package com.dh.DentalClinicMVC.dao;

import com.dh.DentalClinicMVC.model.Appointment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppointmentDaoList implements  IDao<Appointment>{

    private List<Appointment> appointments;

    public AppointmentDaoList() {
        appointments = new ArrayList<>();
    }

    @Override
    public Appointment save(Appointment appointment) {
        // guardamos en la lista el turno que recibimos por parametro
        appointments.add(appointment);
        return appointment;
    }

    @Override
    public Appointment findById(Integer id) {
        Appointment appointmentToLookFor = null;
        // recorrer la lista con un bucle
        for (Appointment a : appointments) {
            // chequeamos que el ID del turno matchee con el ID que estamos buscando
            if (a.getId() == id) {
                appointmentToLookFor = a;
                return appointmentToLookFor;
            }
        }
        return appointmentToLookFor;
    }

    @Override
    public void update(Appointment appointment) {

    }

    @Override
    public void delete(Integer t) {

    }

    @Override
    public List<Appointment> findAll() {
        return appointments;
    }

    @Override
    public Appointment findByString(String value) {
        return null;
    }
}
