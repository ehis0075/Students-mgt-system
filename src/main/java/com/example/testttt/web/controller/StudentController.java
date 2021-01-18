package com.example.testttt.web.controller;

import com.example.testttt.model.Student;
import com.example.testttt.model.StudentDTO;
import com.example.testttt.repository.StudentRepository;
import com.example.testttt.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentServiceImpl studentService;

    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @PostMapping("/student")
    public ResponseEntity<Student> saveStudent(@RequestBody StudentDTO studentDTO){

        Student result = studentService.saveStudent(studentDTO);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/students")
    public Collection<Student> getAllStudents(){

        Collection<Student> results = studentService.getAllStudents();

        return results;
    }

    @GetMapping("/{username}")
    public ResponseEntity<Student> findStudentByUsername(@PathVariable String username){

        Student r = studentService.findStudentByUsername(username);

        return new ResponseEntity<>(r, HttpStatus.OK);

    }

    @PutMapping("/{username}")
    public ResponseEntity<Student> updateStudent(@RequestBody StudentDTO studentDTO, @PathVariable String username){

       Student d =  studentService.updateStudent(studentDTO, username);

        return new ResponseEntity<>(d, HttpStatus.CREATED);
    }

    @DeleteMapping("/{username}")
    public void deleteStudent(@PathVariable String username ){

        studentService.deleteStudentByUsername(username);
    }




}
