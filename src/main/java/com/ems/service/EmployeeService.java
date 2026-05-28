package com.ems.service;

import com.ems.dto.EmployeeRequest;
import com.ems.dto.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    EmployeeResponse createEmployee(EmployeeRequest request);
    List<EmployeeResponse> getAllEmployee();
    EmployeeResponse getEmployeeById(Long id);
    EmployeeResponse updateEmployee(EmployeeRequest request, Long id);
    String deleteEmployee(Long id);
    EmployeeResponse getEmployeeByName(String name);
}
