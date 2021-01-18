package com.example.testttt.service;


import com.example.testttt.model.Student;
import com.example.testttt.model.StudentDTO;

import java.util.Collection;

public interface StudentService {

    public Student saveStudent(StudentDTO studentDTO);

    public Student updateStudent(StudentDTO studentDTO, String username);

    Collection<Student> getAllStudents();

    public Student findStudentByUsername(String username);

    void deleteStudentByUsername(String username);

}
