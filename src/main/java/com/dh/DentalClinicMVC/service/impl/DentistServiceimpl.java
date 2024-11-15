package com.dh.DentalClinicMVC.service.impl;

import com.dh.DentalClinicMVC.entity.Dentist;
import com.dh.DentalClinicMVC.repository.IDentistRepository;
import com.dh.DentalClinicMVC.service.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistServiceimpl implements IDentistService {

    private IDentistRepository dentistRepository;

    @Autowired
    public DentistServiceimpl(IDentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Override
    public Dentist save(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public Optional<Dentist> findByid(Long id) {
        return dentistRepository.findById(id);
    }

    @Override
    public void update(Dentist dentist) {
        dentistRepository.save(dentist);
    }

    @Override
    public void delete(Long id) {
        dentistRepository.deleteById(id);
    }

    @Override
    public List<Dentist> findAll() {
        return dentistRepository.findAll();
    }

    @Override
    public Optional<Dentist> findByRegistration(Integer registration) {
        return dentistRepository.findByRegistration(registration);
    }
}
