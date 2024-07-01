package com.IntroToSpring.Lab402IntroToSpringBoot.controller.impl;

import com.IntroToSpring.Lab402IntroToSpringBoot.model.Employee;
import com.IntroToSpring.Lab402IntroToSpringBoot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllDoctors() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable Long employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if (employeeOptional.isEmpty()) return null;
        return employeeOptional.get();
    }

    @GetMapping("/employees/{status}")
    public List<Employee> getEmployeeByStatus(@PathVariable String status) {
        return employeeRepository.findByStatus(status);
    }




}
