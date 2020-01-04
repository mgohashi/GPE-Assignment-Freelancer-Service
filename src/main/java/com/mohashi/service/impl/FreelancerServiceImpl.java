package com.mohashi.service.impl;

import java.util.List;
import java.util.Optional;

import com.mohashi.model.Freelancer;
import com.mohashi.repository.FreelancerRepository;
import com.mohashi.service.FreelancerService;

import org.springframework.stereotype.Service;

@Service
public class FreelancerServiceImpl implements FreelancerService {

    public FreelancerRepository repository;

    public FreelancerServiceImpl(FreelancerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void deleteById(Long freelancerId) {
        repository.deleteById(freelancerId);
    }

    @Override
    public List<Freelancer> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Freelancer> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Freelancer save(Freelancer freelancer) {
        return repository.save(freelancer);
    }
    
}