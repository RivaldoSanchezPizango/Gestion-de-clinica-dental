package com.dh.DentalClinicMVC.controller;

import com.dh.DentalClinicMVC.entity.Dentist;
import com.dh.DentalClinicMVC.service.IDentistService;
import org.junit.jupiter.api.*;
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
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DentistControllerTest {

    @Autowired
    private MockMvc mockMvc; // simula el comportamiento de un contenedor

    @Autowired
    private IDentistService iDentistService;

    public void dataLoad(){
        Dentist dentist = new Dentist();
         dentist.setRegistration(2478);
         dentist.setName("Oiler");
         dentist.setLastName("Sanchez");
         iDentistService.save(dentist);
    }

    @Test
    @Order(2)
    public void testGetDentistById() throws Exception {
        dataLoad();
        mockMvc.perform(get("/odontologos/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.registration").value("2478"))
                .andExpect(jsonPath("$.name").value("Oiler"))
                .andExpect(jsonPath("$.lastName").value("Sanchez"));
    }

    @Test
    @Order(3)
    public void testPostDentist() throws Exception {
        String dentistSaved = "{\"registration\": \"1253\",\"name\": \"Lidia\",\"lastName\": \"Pizango\"}";

        mockMvc.perform(post("/odontologos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dentistSaved)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.registration").value("1253"))
                .andExpect(jsonPath("$.name").value("Lidia"))
                .andExpect(jsonPath("$.lastName").value("Pizango"));
    }

    @Test
    @Order(1)
    public void testGetAllDentist() throws Exception {
        mockMvc.perform(get("/odontologos"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

}