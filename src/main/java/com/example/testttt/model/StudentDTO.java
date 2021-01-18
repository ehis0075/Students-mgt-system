package com.example.testttt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDTO {

    private String username;

    private String password;

    private Role role;
}
