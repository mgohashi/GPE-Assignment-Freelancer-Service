package com.mohashi;

import java.util.List;

import com.mohashi.model.Freelancer;
import com.mohashi.repository.FreelancerRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FreelacerController {

    private FreelancerRepository repository;

    public FreelacerController(FreelancerRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/freelancers")
    public Freelancer newFreelancer(@RequestBody Freelancer freelancer) {
        return this.repository.save(freelancer);
    }

    @GetMapping("/freelancers")
    public List<Freelancer> getAll() {
        return this.repository.findAll();
    }

    @GetMapping("/freelancers/{id}")
    public Freelancer get(@PathVariable Long id) {
        return this.repository.findById(id).orElseThrow(() -> new FreelancerNotFoundException(id));
    }

    @PutMapping("/freelancers/{id}")
    public Freelancer replaceFreelancer(@RequestBody Freelancer newFreelancer, @PathVariable Long id) {
        return repository.findById(id).map(freelancer -> {
            freelancer.setFirstName(newFreelancer.getFirstName());
            freelancer.setLastName(newFreelancer.getLastName());
            freelancer.setEmailAddress(newFreelancer.getEmailAddress());
            freelancer.setSkills(newFreelancer.getSkills());
            return repository.save(freelancer);
        }).orElseThrow(() -> new FreelancerNotFoundException(id));
    }

    @DeleteMapping("/freelancers/{id}")
    public void deleteFreelancer(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
