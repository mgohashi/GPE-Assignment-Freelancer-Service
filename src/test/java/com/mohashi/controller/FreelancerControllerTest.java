package com.mohashi.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.mohashi.model.Freelancer;
import com.mohashi.model.Skill;
import com.mohashi.service.FreelancerService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(FreelancerController.class)
public class FreelancerControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private FreelancerService service;

    @Test
    public void givenFreelancers_whenGetFrelancers_thenReturnJsonArray() throws Exception {
        Freelancer alex = new Freelancer(new Long(1), "Alex", "Bilbao", "abilbao@gmail.com", 
            Arrays.asList(new Skill(new Long(2), "Java"), new Skill(new Long(3), ".Net")));

        List<Freelancer> allFreelancers = Arrays.asList(alex);

        given(service.findAll()).willReturn(allFreelancers);

        mvc.perform(get("/freelancers").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].firstName", is(alex.getFirstName())));
    }

    @Test
    public void givenFreelancer_whenGetFrelancer_thenReturnJsonArray() throws Exception {
        Freelancer alex = new Freelancer(new Long(1), "Alex", "Bilbao", "abilbao@gmail.com", 
            Arrays.asList(new Skill(new Long(2), "Java"), new Skill(new Long(3), ".Net")));

        given(service.findById(new Long(1))).willReturn(Optional.of(alex));

        mvc.perform(get("/freelancers/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is(alex.getFirstName())));
    }
}