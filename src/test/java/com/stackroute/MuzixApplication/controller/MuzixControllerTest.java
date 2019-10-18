package com.stackroute.MuzixApplication.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.MuzixApplication.domain.Muzix;
import com.stackroute.MuzixApplication.exception.MuzixAlreadyExists;
import com.stackroute.MuzixApplication.service.MuzixService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class MuzixControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private Muzix muzix;
    @MockBean
    private MuzixService muzixService;
    @InjectMocks
    private MuzixController muzixController;

    private List<Muzix> list =null;

    @Before
    public void setUp(){

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(muzixController).build();
        muzix=new Muzix();


        muzix.setName("Jonny");
        muzix.setId(101);
        muzix.setComment("Jenny");

        list = new ArrayList();
        list.add(muzix);
    }

    @Test
    public void saveUser() throws Exception {
        when(muzixService.saveNewMuzix(any())).thenReturn(muzix);
        mockMvc.perform(MockMvcRequestBuilders.post("/muzix/")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(muzix)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());


    }
    @Test
    public void saveUserFailure() throws Exception {
        when(muzixService.saveNewMuzix(any())).thenThrow(MuzixAlreadyExists.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/muzix/")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(muzix)))
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andDo(MockMvcResultHandlers.print());
    }
//
    @Test
    public void getAllUser() throws Exception {
        when(muzixService.getAllMuzix()).thenReturn((ArrayList<Muzix>) list);
        mockMvc.perform(MockMvcRequestBuilders.get("/muzix/")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(muzix)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }
//
//
    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
//
//    @Test
//    public void saveNewMuzix() {
//    }
//
//    @Test
//    public void trackByName() {
    }}
