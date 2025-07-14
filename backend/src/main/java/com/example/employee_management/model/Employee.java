package com.example.employee_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")  // Use your exact table name here
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String empCode;
    private String email;
    private String phone;
    private boolean workingStatus;
    private String address;
    private String department;
    private String job;
    private double salary;

    public Employee() {}

    // Getters and setters (generate via IDE or write manually)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmpCode() { return empCode; }
    public void setEmpCode(String empCode) { this.empCode = empCode; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public boolean isWorkingStatus() { return workingStatus; }
    public void setWorkingStatus(boolean workingStatus) { this.workingStatus = workingStatus; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getJob() { return job; }
    public void setJob(String job) { this.job = job; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}
