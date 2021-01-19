package com.example.testttt.repository;

import com.example.testttt.model.Role;
import com.example.testttt.model.AppUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private AppUserRepository studentRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void save() {
        AppUser user = new AppUser();
        user.setUsername("tobi");
        user.setPassword("tobi");
        user.setRole(Role.LECTURER);

        studentRepository.save(user);

        log.info("Lift object after saving --> {}", user);
        assertThat(user.getStudentId()).isNotNull();

    }

}