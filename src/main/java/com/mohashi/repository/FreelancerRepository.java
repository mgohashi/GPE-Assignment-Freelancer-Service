package com.mohashi.repository;

import com.mohashi.model.Freelancer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreelancerRepository extends JpaRepository<Freelancer, Long> {
    public Freelancer findByFirstName(String firstName);
}