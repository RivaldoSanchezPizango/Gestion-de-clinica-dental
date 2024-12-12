package com.dh.DentalClinicMVC.controller;

import com.dh.DentalClinicMVC.entity.Dentist;
import com.dh.DentalClinicMVC.service.IDentistService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class DentistControllerTest {

    @Autowired
    private MockMvc mockMvc; // simula el comportamiento de un contenedor

    @Autowired
    private IDentistService iDentistService;

    @BeforeEach
    public void dataLoad(){
        Dentist dentist = new Dentist();
         dentist.setRegistration(2478);
         dentist.setName("Oiler");
         dentist.setLastName("Sanchez");
         iDentistService.save(dentist);
    }

    @Test
    public void testGetDentistById() throws Exception {
        mockMvc.perform(get("/odontologos/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.registration").value("2478"))
                .andExpect(jsonPath("$.name").value("Oiler"))
                .andExpect(jsonPath("$.lastName").value("Sanchez"));
    }

}