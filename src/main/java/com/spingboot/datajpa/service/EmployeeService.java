package com.spingboot.datajpa.service;

import com.spingboot.datajpa.model.Employee;
import com.spingboot.datajpa.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public ArrayList<Employee> getAllEmployees() {
        return (ArrayList<Employee>) employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id){
        Optional<Employee> opt = employeeRepository.findById(id);
        return opt.orElse(null);
    }


    public String saveEmployee(Employee employee) {
       if(employee != null) {
          Employee  newEmployee = new Employee();
          newEmployee.setEmpName(employee.getEmpName());
          employeeRepository.save(newEmployee);
       }
        return "New Employee Saved !!!";
    }


}
