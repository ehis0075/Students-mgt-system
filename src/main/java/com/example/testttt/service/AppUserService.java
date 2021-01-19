package com.example.testttt.service;


import com.example.testttt.model.AppUser;

import com.example.testttt.model.AppUserDTO;

import java.util.Collection;

public interface AppUserService {

    public AppUser saveStudent(AppUserDTO appUserDTO);

    public AppUser updateStudent(AppUserDTO appUserDTO, String username);

    Collection<AppUser> getAllStudents();

    public AppUser findStudentByUsername(String username);

    void deleteStudentByUsername(String username);

}
