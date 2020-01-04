package com.mohashi;

public class FreelancerNotFoundException extends RuntimeException {
    public FreelancerNotFoundException(Long id) {
        super("Could not find freelancer " + id);
    }
}