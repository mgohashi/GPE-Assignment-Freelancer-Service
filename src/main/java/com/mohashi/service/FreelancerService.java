package com.mohashi.service;

import java.util.List;
import java.util.Optional;

import com.mohashi.model.Freelancer;

public interface FreelancerService {
    List<Freelancer> findAll();
    Optional<Freelancer> findById(Long freelancerId);
    Freelancer save(Freelancer freelancer);
    void deleteById(Long freelancerId);
}