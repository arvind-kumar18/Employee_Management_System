package com.ems.controller;

import com.ems.dto.EmployeeRequest;
import com.ems.dto.EmployeeResponse;
import com.ems.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/createEmp")
    public ResponseEntity<EmployeeResponse> createEmployee(@Valid @RequestBody EmployeeRequest request){

        return new ResponseEntity<>(service.createEmployee(request), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployee(){
        return ResponseEntity.ok(service.getAllEmployee());
    }

    @GetMapping("/EmpId/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok(service.getEmployeeById(id));
    }

    @GetMapping("/EmpName/{name}")
    public ResponseEntity<EmployeeResponse> getEmployeeByName(@PathVariable String name){
        return ResponseEntity.ok(service.getEmployeeByName(name));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@RequestBody EmployeeRequest request, @PathVariable Long id ){
        return ResponseEntity.ok(service.updateEmployee(request, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        return ResponseEntity.ok(service.deleteEmployee(id));
    }
}
