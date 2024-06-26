package com.luv2code.springboot.cruddemonew.rest;

import com.luv2code.springboot.cruddemonew.dao.EmployeeDao;
import com.luv2code.springboot.cruddemonew.entity.Employee;
import com.luv2code.springboot.cruddemonew.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    //quick and dirty: inject employee dao
//    private EmployeeDao employeeDao;
//    public EmployeeRestController(EmployeeDao employeeDao) {
//        this.employeeDao = employeeDao;
//    }

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    //expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> finAll() {
        return employeeService.findAll();
    }

    // add mapping for Get /employee/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Employee employee =employeeService.findById(employeeId);
        if(employee == null) {
            throw new RuntimeException("Employee not found - "+employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employeeId){
        // also just in case they pass an id in JSON ... set id to 0
        // This is to force a save of new item ... instead od update
        employeeId.setId(0);
        Employee employee =employeeService.save(employeeId);
        return employee;
    }

    // add mapping for put employees updating for existing employees
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employeeId){
        Employee employee =employeeService.save(employeeId);
        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee tempEmployee = employeeService.findById(employeeId);
        // throw exception if null
        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }
}
