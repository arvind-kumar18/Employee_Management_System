package com.ems.service;

import com.ems.dto.EmployeeRequest;
import com.ems.dto.EmployeeResponse;
import com.ems.entity.Employee;
import com.ems.exception.EmployeeIdNotFoundException;
import com.ems.exception.EmployeeNameNotFoundException;
import com.ems.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo repo;

    public Employee mapToEntity(EmployeeRequest request){
        Employee employee = new Employee();

        employee.setName(request.getName());
        employee.setDeptName(request.getDeptName());
        employee.setMobile(request.getMobile());
        employee.setEmail(request.getEmail());
        employee.setAddress(request.getAddress());

        return employee;
    }

    public EmployeeResponse mapToResponse(Employee employee){
        EmployeeResponse response = new EmployeeResponse();
        response.setId(employee.getId());
        response.setName(employee.getName());
        response.setDeptName(employee.getDeptName());
        response.setMobile(employee.getMobile());
        response.setEmail(employee.getEmail());
        response.setAddress(employee.getAddress());

        return response;
    }

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest request) {
        Employee employee = mapToEntity(request);
        Employee employee1 = repo.save(employee);
        return mapToResponse(employee1);

    }

    @Override
    public List<EmployeeResponse> getAllEmployee() {
        List<Employee> employeeList = repo.findAll();
        return employeeList.stream().map(this::mapToResponse).toList();
    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) {
        Employee employee = repo.findById(id)
                .orElseThrow(()->new EmployeeIdNotFoundException("Employee Not found with this id"));

        return mapToResponse(employee);
    }

    @Override
    public EmployeeResponse updateEmployee(EmployeeRequest request, Long id) {
        Employee employee = repo.findById(id)
                .orElseThrow(()->new EmployeeIdNotFoundException("Employee Not found with this id"));

        employee.setName(request.getName());
        employee.setDeptName(request.getDeptName());
        employee.setMobile(request.getMobile());
        employee.setEmail(request.getEmail());
        employee.setAddress(request.getAddress());

        Employee updated = repo.save(employee);
        return mapToResponse(updated);
    }

    @Override
    public String deleteEmployee(Long id) {
        Employee employee = repo.findById(id)
                .orElseThrow(()->new EmployeeIdNotFoundException("Employee Not found with this id"));

        repo.delete(employee);
        return "Employee Deleted Successfully";
    }

    @Override
    public EmployeeResponse getEmployeeByName(String name) {
        Employee employee = repo.findEmployeeByName(name)
                .orElseThrow(()->new EmployeeNameNotFoundException("No Employee Found with this Name"));

        return mapToResponse(employee);
    }
}
