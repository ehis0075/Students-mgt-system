package com.example.testttt.repository;

import com.example.testttt.model.Role;
import com.example.testttt.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@Slf4j
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void save() {
        Student user = new Student();
        user.setUsername("kel");
        user.setPassword("kel");
        user.setRole(Role.USER);

        studentRepository.save(user);

        log.info("Lift object after saving --> {}", user);
        assertThat(user.getStudentId()).isNotNull();

    }

}