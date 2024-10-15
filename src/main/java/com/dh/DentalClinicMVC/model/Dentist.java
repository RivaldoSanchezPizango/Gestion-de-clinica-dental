package com.dh.DentalClinicMVC.model;

public class Dentist {

    private Integer id;
    private Integer registraation;
    private String name;
    private String lastName;

    public Dentist(Integer id, Integer registraation, String name, String lastName) {
        this.id = id;
        this.registraation = registraation;
        this.name = name;
        this.lastName = lastName;
    }

    public Dentist(Integer registraation, String name, String lastName) {
        this.registraation = registraation;
        this.name = name;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRegistraation() {
        return registraation;
    }

    public void setRegistraation(Integer registraation) {
        this.registraation = registraation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
