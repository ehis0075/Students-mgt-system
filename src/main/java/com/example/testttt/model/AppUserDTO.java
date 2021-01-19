package com.example.testttt.model;

import com.example.testttt.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppUserDTO {

    private String username;

    private String password;

    private Role role;
}
