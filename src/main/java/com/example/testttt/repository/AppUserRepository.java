package com.example.testttt.repository;


import com.example.testttt.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@EnableJpaRepositories
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String username);

    void deleteByUsername(String username);

    //ResponseEntity<Student> saveStudent(StudentDTO studentDTO);
}
