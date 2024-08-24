package com.spingboot.datajpa.controller;

import com.spingboot.datajpa.model.Employee;
import com.spingboot.datajpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/allemployees")
    public ArrayList<Employee> findAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/empById/{id}")
    public Employee findEmployeeById (@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/create")
    public @ResponseBody String saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

}
