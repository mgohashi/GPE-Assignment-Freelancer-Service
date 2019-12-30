package com.mohashi;

class FreelancerNotFoundException extends RuntimeException {
    FreelancerNotFoundException(Long id) {
        super("Could not find freelancer " + id);
    }
}