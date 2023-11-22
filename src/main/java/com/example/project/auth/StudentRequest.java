package com.example.project.auth;

import com.example.project.model.Role;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
    public String department;
    public String program;
    public String yearOfSubmission;
    public String dateOfBirth;
    public String idNo;
    public String permanentAddress;
    public String phone;
    public String nationality;

}
