package com.mohashi.controller;

import java.util.List;

import com.mohashi.FreelancerNotFoundException;
import com.mohashi.model.Freelancer;
import com.mohashi.service.FreelancerService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FreelancerController {

    private FreelancerService service;

    public FreelancerController(FreelancerService service) {
        this.service = service;
    }

    @PostMapping("/freelancers")
    public Freelancer newFreelancer(@RequestBody Freelancer freelancer) {
        return this.service.save(freelancer);
    }

    @GetMapping("/freelancers")
    public List<Freelancer> getAll() {
        return this.service.findAll();
    }

    @GetMapping("/freelancers/{id}")
    public Freelancer get(@PathVariable Long id) {
        return this.service.findById(id).orElseThrow(() -> new FreelancerNotFoundException(id));
    }

    @PutMapping("/freelancers/{id}")
    public Freelancer replaceFreelancer(@RequestBody Freelancer newFreelancer, @PathVariable Long id) {
        return service.findById(id).map(freelancer -> {
            freelancer.setFirstName(newFreelancer.getFirstName());
            freelancer.setLastName(newFreelancer.getLastName());
            freelancer.setEmailAddress(newFreelancer.getEmailAddress());
            freelancer.setSkills(newFreelancer.getSkills());
            return service.save(freelancer);
        }).orElseThrow(() -> new FreelancerNotFoundException(id));
    }

    @DeleteMapping("/freelancers/{id}")
    public void deleteFreelancer(@PathVariable Long id) {
        service.deleteById(id);
    }
}
