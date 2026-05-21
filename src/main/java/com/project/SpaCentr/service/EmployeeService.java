package com.project.SpaCentr.service;

import com.project.SpaCentr.model.dto.request.CreateEmployeeRequest;
import com.project.SpaCentr.model.dto.response.EmployeeCreatedResponse;
import com.project.SpaCentr.model.dto.response.EmployeeResponse;
import com.project.SpaCentr.model.entity.Employee;
import com.project.SpaCentr.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private  final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }
    public EmployeeCreatedResponse createEmployee(CreateEmployeeRequest createEmployeeRequest){
        Employee existing = employeeRepository.findByUsername(createEmployeeRequest.username());
        if(existing != null){
            throw new ResponseStatusException(CONFLICT,"Username already exist");
        }
        String plainPin = "";
        if(createEmployeeRequest.password() != null || !createEmployeeRequest.password().isBlank()){
            plainPin = createEmployeeRequest.password();
        }
        Employee employee = modelMapper.map(createEmployeeRequest,Employee.class);
        employee.setPassword(passwordEncoder.encode(plainPin));
        employee.setEnabled(true);

        Employee saved = employeeRepository.save(employee);
        return new EmployeeCreatedResponse(saved.getId(),saved.getUsername(),saved.getFullName(),saved.getRole(),saved.isEnabled(),plainPin);
    }
    public List<EmployeeResponse> employeeList(){
        List<Employee> employees = employeeRepository.findAll();
        return  employees.stream().map(e -> modelMapper.map(e,EmployeeResponse.class)).toList();

    }
    public  EmployeeCreatedResponse updatePassword(long employeeId, String pass){
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResponseStatusException(NOT_FOUND,"Employee not found"));
        employee.setPassword(passwordEncoder.encode(pass));
        Employee saved = employeeRepository.save(employee);
        return  new EmployeeCreatedResponse(saved.getId(),
                saved.getUsername(),
                saved.getFullName(),
                saved.getRole(),
                saved.isEnabled(),pass);
    }
}
