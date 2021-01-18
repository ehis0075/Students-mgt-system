package com.example.testttt.service;

import com.example.testttt.model.Student;
import com.example.testttt.model.StudentDTO;
import com.example.testttt.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(StudentDTO studentDTO) {

        Student student = new Student();
        student.setUsername(studentDTO.getUsername());
        student.setPassword(studentDTO.getPassword());
        student.setRole(studentDTO.getRole());
        Student result =  studentRepository.save(student);

        return result;

    }

    @Override
    public Student updateStudent(StudentDTO studentDTO, String username) {

        Student existingStudent = studentRepository.findByUsername(username);

        if(existingStudent != null){
            existingStudent.setUsername(studentDTO.getUsername());
            existingStudent.setPassword(studentDTO.getPassword());
            existingStudent.setRole(studentDTO.getRole());

        }

        return studentRepository.save(existingStudent);
    }

    @Override
    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentByUsername(String username) {

        Student results = studentRepository.findByUsername(username);

        return results;
    }

    @Override
    public void deleteStudentByUsername(String username) {

        studentRepository.deleteByUsername(username);
    }
}
