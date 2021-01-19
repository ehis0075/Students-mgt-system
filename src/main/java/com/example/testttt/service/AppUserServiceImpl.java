package com.example.testttt.service;

import com.example.testttt.model.AppUser;
import com.example.testttt.model.AppUserDTO;
import com.example.testttt.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AppUserServiceImpl implements AppUserService {


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AppUserRepository studentRepository;



    @Override
    public AppUser saveStudent(AppUserDTO appUserDTO) {

        AppUser student = new AppUser();
        student.setUsername(appUserDTO.getUsername());
        student.setPassword(bCryptPasswordEncoder.encode(appUserDTO.getPassword()));
        student.setRole(appUserDTO.getRole());
        AppUser result =  studentRepository.save(student);

        return result;

    }

    @Override
    public AppUser updateStudent(AppUserDTO appUserDTO, String username) {

        AppUser existingStudent = studentRepository.findByUsername(username);

        if(existingStudent != null){
            existingStudent.setUsername(appUserDTO.getUsername());
            existingStudent.setPassword(appUserDTO.getPassword());
            existingStudent.setRole(appUserDTO.getRole());

        }

        return studentRepository.save(existingStudent);
    }

    @Override
    public Collection<AppUser> getAllStudents() {
        return studentRepository.findAll();
    }


    @Override
    public AppUser findStudentByUsername(String username) {

        AppUser results = studentRepository.findByUsername(username);

        return results;
    }

    @Override
    public void deleteStudentByUsername(String username) {

        studentRepository.deleteByUsername(username);
    }
}
