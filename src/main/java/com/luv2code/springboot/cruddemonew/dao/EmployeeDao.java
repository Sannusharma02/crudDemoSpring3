package com.luv2code.springboot.cruddemonew.dao;

import com.luv2code.springboot.cruddemonew.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int employee);

}
