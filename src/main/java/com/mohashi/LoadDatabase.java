package com.mohashi;

import java.util.Arrays;

import com.mohashi.model.Freelancer;
import com.mohashi.model.Skill;
import com.mohashi.repository.FreelancerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(FreelancerRepository repository) {
        return args -> {
            log.info("Erasing all... ");
            repository.deleteAll();

            log.info("Preloading " + repository.save(new Freelancer(null, "Robert", "Calva", "rcalva@gmail.com", Arrays.asList(new Skill(null, "Java"), new Skill(null, "PHP")))));
            log.info("Preloading " + repository.save(new Freelancer(null, "Daniel", "Turkey", "dturkey@gmail.com", Arrays.asList(new Skill(null, ".Net"), new Skill(null, "Golang")))));
        };
    }

}