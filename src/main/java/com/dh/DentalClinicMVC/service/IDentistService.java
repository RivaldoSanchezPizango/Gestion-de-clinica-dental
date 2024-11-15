package com.dh.DentalClinicMVC.service;

import com.dh.DentalClinicMVC.entity.Dentist;

import java.util.List;
import java.util.Optional;

public interface IDentistService {

    Dentist save(Dentist dentist);
    Optional<Dentist> findByid(Long id);
    void update(Dentist dentist);
    void delete (Long id);
    List<Dentist> findAll();
    static Optional<Dentist> findByRegistration(Integer registration);

}
