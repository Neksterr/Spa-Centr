package com.project.SpaCentr.security;

import com.project.SpaCentr.model.entity.Employee;
import com.project.SpaCentr.repository.EmployeeRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class EmployeeUserDetails implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    public EmployeeUserDetails(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Employee  not found"));

        return null;
    }
}
