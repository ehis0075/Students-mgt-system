package com.example.testttt.repository;


import com.example.testttt.model.Student;
import com.example.testttt.model.StudentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@EnableJpaRepositories
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByUsername(String username);

    void deleteByUsername(String username);

    //ResponseEntity<Student> saveStudent(StudentDTO studentDTO);
}
