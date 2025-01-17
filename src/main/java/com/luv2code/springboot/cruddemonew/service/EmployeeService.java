package com.luv2code.springboot.cruddemonew.service;

import com.luv2code.springboot.cruddemonew.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
