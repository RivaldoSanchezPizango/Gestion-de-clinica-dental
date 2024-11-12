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

        // convertir el string del turno dto que es la fecha a un LOCALDATE
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(appointmentDTO.getDate(), formatter);

        // seteamos la fecha
        appointmentEntity.setDate(date);

        // persistir en la BD
        iAppointmentRepository.save(appointmentEntity);

        return iAppointmentRepository.save(appointmentDTO);
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

