package com.project.SpaCentr.controller;

import com.project.SpaCentr.model.dto.CreateEmployeeDto;
import com.project.SpaCentr.model.dto.EmployeeCreatedResponse;
import com.project.SpaCentr.model.dto.EmployeeResponse;
import com.project.SpaCentr.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/employees")
public class AdminEmployeeController {
    private final EmployeeService employeeService;

    public AdminEmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping
    public EmployeeCreatedResponse create(@Valid @RequestBody CreateEmployeeDto createEmployeeDto){
        return employeeService.createEmployee(createEmployeeDto);
    }
    @GetMapping
    public List<EmployeeResponse> listOfEmployees(){
        return employeeService.employeeList();
    }
    @PostMapping("/{id}/reset-password")
    private EmployeeCreatedResponse resetPassword(@PathVariable long id,@RequestParam String pass){
        return  employeeService.updatePassword(id,pass);
    }
}
