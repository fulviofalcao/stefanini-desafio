package com.api.stefaniniapi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

public class PersonControllerTest extends StefaniniApiApplicationTests {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetAllPersons() throws Exception {
        mockMvc.perform(get("/stefanini-api-rest/api/v1/persons")).andExpect(status().isOk());
    }

    @Test
    public void testGetAllPersonsIsNotFound() throws Exception {
        mockMvc.perform(get("/stefanini-api-rest/api/v1/persons")).andExpect(status().isNotFound());
    }

    @Test
    public void testGetPersonById() throws Exception {
         mockMvc.perform(get("/stefanini-api-rest/api/v1/persons")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.id").value(1L));
    }

    @Test
    public void testGetPersonByIdIsNotFound() throws Exception {
        mockMvc.perform(get("/stefanini-api-rest/api/v1/persons")).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.id").value(1L));
    }


    @Test
    public void testCreatePerson() throws Exception {
        mockMvc.perform(post("/stefanini-api-rest/api/v1/persons")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.fullName").value("josé silva"))
                .andExpect(jsonPath("$.gender").value("masculino"))
                .andExpect(jsonPath("$.emailId").value("email@localhost.com"))
                .andExpect(jsonPath("$.dateBirth").value(new Date()))
                .andExpect(jsonPath("$.placeBirth").value("recife"))
                .andExpect(jsonPath("$.nationality").value("Brasileira"))
                .andExpect(jsonPath("$.cpf").value("143.640.970-55"));
    }

    @Test
    public void testCreatePersonIsNotFound() throws Exception {
        mockMvc.perform(post("/stefanini-api-rest/api/v1/persons")).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.fullName").value("josé silva"))
                .andExpect(jsonPath("$.gender").value("masculino"))
                .andExpect(jsonPath("$.emailId").value("email@localhost.com"))
                .andExpect(jsonPath("$.dateBirth").value(new Date()))
                .andExpect(jsonPath("$.placeBirth").value("recife"))
                .andExpect(jsonPath("$.nationality").value("Brasileira"))
                .andExpect(jsonPath("$.cpf").value("143.640.970-55"));
    }

    @Test
    public void testUpdatePerson() throws Exception {
        mockMvc.perform(put("/stefanini-api-rest/api/v1/persons")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.fullName").value("josé silva souza"))
                .andExpect(jsonPath("$.gender").value("masculino"))
                .andExpect(jsonPath("$.emailId").value("email@localhost.com"))
                .andExpect(jsonPath("$.dateBirth").value(new Date()))
                .andExpect(jsonPath("$.placeBirth").value("recife"))
                .andExpect(jsonPath("$.nationality").value("Brasileira"))
                .andExpect(jsonPath("$.cpf").value("143.640.970-55"));
    }

    @Test
    public void testUpdatePersonIsNotFound() throws Exception {
        mockMvc.perform(put("/stefanini-api-rest/api/v1/persons")).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.fullName").value("josé silva souza"))
                .andExpect(jsonPath("$.gender").value("masculino"))
                .andExpect(jsonPath("$.emailId").value("email@localhost.com"))
                .andExpect(jsonPath("$.dateBirth").value(new Date()))
                .andExpect(jsonPath("$.placeBirth").value("recife"))
                .andExpect(jsonPath("$.nationality").value("Brasileira"))
                .andExpect(jsonPath("$.cpf").value("143.640.970-55"));
    }

    @Test
    public void testDeletePersonIsOk() throws Exception {
        mockMvc.perform(delete("/stefanini-api-rest/api/v1/persons")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.id").value(1L));
    }

    @Test
    public void testDeletePersonIsNotFound() throws Exception {
        mockMvc.perform(delete("/stefanini-api-rest/api/v1/persons")).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.id").value(1L));
    }

}
