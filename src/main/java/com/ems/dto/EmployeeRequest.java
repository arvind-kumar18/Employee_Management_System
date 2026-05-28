package com.ems.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {

    @NotBlank(message = "Name Field Can not be Blank")
    private String name;

    @NotBlank(message = "Department Field Can not be Blank")
    private String deptName;

    @NotBlank(message = "Mobile Field Can not be Blank")
    private String mobile;

    @NotBlank(message = "Email Field Can not be Blank")
    @Email
    private String email;

    @NotBlank(message = "Address Field Can not be Blank")
    private String address;
}
