package com.dh.DentalClinicMVC.dao;

import com.dh.DentalClinicMVC.model.Patient;

import java.sql.*;
import java.util.List;

public class PatientDaoH2 implements IDao<Patient>{
    private static final String SQL_INSERT = "INSERT INTO PACIENTS (NAME, LAST_NAME, CARD_IDENTITY, " +
            "ADMISSION_OF_DATE, ADDRESS_ID) VALUES (?,?,?,?,?)";

    @Override
    public Patient save(Patient patient) {
        Connection connection = null;

        try {
            AddresDaoH2 addresDaoH2 = new AddresDaoH2();
            addresDaoH2.save(patient.getAddress());

            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, patient.getName());
            ps.setString(2, patient.getLastName());
            ps.setInt(3,patient.getCardIdentity());
            ps.setDate(4, Date.valueOf(patient.getAdmissionOfDate()));
            ps.setInt(5, patient.getAddress().getId());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                patient.setId(rs.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return patient;
    }

    @Override
    public Patient findById(Integer id) {
        return null;
    }

    @Override
    public void update(Patient patient) {

    }

    @Override
    public void delete(Integer t) {

    }

    @Override
    public List<Patient> findAll() {
        return List.of();
    }
}
