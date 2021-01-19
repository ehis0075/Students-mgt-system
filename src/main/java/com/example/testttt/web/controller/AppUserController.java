package com.example.testttt.web.controller;

import com.example.testttt.model.AppUser;
import com.example.testttt.model.AppUserDTO;
import com.example.testttt.repository.AppUserRepository;
import com.example.testttt.service.AppUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RequestMapping("/student")
@RestController
public class AppUserController {

    @Autowired
    private AppUserRepository studentRepository;

    @Autowired
    private AppUserServiceImpl studentService;

    public AppUserController(AppUserRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<AppUser> registerNewUser(@RequestBody AppUserDTO appUserDTO){

        AppUser result = studentService.saveStudent(appUserDTO);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/students")
    public Collection<AppUser> getAllStudents(){

        Collection<AppUser> results = studentService.getAllStudents();

        return results;
    }

    @GetMapping("/{username}")
    public ResponseEntity<AppUser> findStudentByUsername(@PathVariable String username){

        AppUser user = studentService.findStudentByUsername(username);

        return new ResponseEntity<>(user, HttpStatus.OK);

    }


    @PutMapping("/{username}")
    public ResponseEntity<AppUser> updateStudent(@RequestBody AppUserDTO appUserDTO, @PathVariable String username){

       AppUser d =  studentService.updateStudent(appUserDTO, username);

        return new ResponseEntity<>(d, HttpStatus.CREATED);
    }

    @DeleteMapping("/{username}")
    public void deleteStudent(@PathVariable String username ){

        studentService.deleteStudentByUsername(username);
    }




}
