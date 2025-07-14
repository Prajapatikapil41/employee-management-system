package com.example.employee_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee_management.model.Employee;
import com.example.employee_management.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAll() { return repository.findAll(); }

    public Employee save(Employee emp) { return repository.save(emp); }

    public Employee update(Long id, Employee emp) {
        Employee e = repository.findById(id).orElseThrow();
        e.setName(emp.getName());
        e.setDepartment(emp.getDepartment());
        e.setSalary(emp.getSalary());
        return repository.save(e);
    }

    public void delete(Long id) { repository.deleteById(id); }
}
