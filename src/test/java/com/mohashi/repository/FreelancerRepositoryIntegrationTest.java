package com.mohashi.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import com.mohashi.model.Freelancer;
import com.mohashi.model.Skill;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FreelancerRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private FreelancerRepository employeeRepository;

    @Test
    public void whenFirstName_thenReturnFreelancer() {
        // given
        Freelancer alex = new Freelancer(null, "Alex", "Bilbao", "abilbao@gmail.com",
                Arrays.asList(new Skill(null, "Java"), new Skill(null, ".Net")));
        alex = entityManager.persist(alex);
        entityManager.flush();

        // when
        Freelancer found = employeeRepository.findByFirstName(alex.getFirstName());

        // then
        assertThat(found.getFirstName()).isEqualTo(alex.getFirstName());
    }

    @Test
    public void whenFreelancersAreStored_thenReturnFreelancers() {
        // given
        Freelancer alex = new Freelancer(null, "Alex", "Bilbao", "abilbao@gmail.com",
                Arrays.asList(new Skill(null, "Java"), new Skill(null, ".Net")));
        alex = entityManager.persist(alex);
        List<Freelancer> expected = Arrays.asList(alex);

        entityManager.flush();

        // when
        List<Freelancer> found = employeeRepository.findAll();

        // then
        assertThat(found).isEqualTo(expected);
    }
}