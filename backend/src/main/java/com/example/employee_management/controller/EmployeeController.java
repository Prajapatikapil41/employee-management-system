package com.example.employee_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_management.model.Employee;
import com.example.employee_management.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin("*")  // Allow all origins for testing
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee empDetails) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));

        employee.setName(empDetails.getName());
        employee.setEmpCode(empDetails.getEmpCode());
        employee.setEmail(empDetails.getEmail());
        employee.setPhone(empDetails.getPhone());
        employee.setWorkingStatus(empDetails.isWorkingStatus());
        employee.setAddress(empDetails.getAddress());
        employee.setDepartment(empDetails.getDepartment());
        employee.setJob(empDetails.getJob());
        employee.setSalary(empDetails.getSalary());

        Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
