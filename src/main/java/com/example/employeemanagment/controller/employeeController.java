package com.example.employeemanagment.controller;

import com.example.employeemanagment.model.Employee;
import com.example.employeemanagment.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/ems")
public class employeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/gets")
    public List<Employee> getAllEmployee(){

        return employeeRepository.findAll();
    }

    @GetMapping("{id}")
    public Employee getEmployeeById(@PathVariable long id){

        return employeeRepository.findById(id).
                orElseThrow(()-> new RuntimeException());
    }

    @PostMapping("/posts")
    public Employee postEmployeeDetails(@RequestBody Employee employee){

        return employeeRepository.save(employee);


    }

    @PutMapping("{id}")
    public Employee updateEmployeeDetails(@RequestBody Employee emp, @PathVariable long id){

        Employee employee = employeeRepository.findById(id).orElseThrow(()->new RuntimeException());
        employee.setEmpName(emp.getEmpName());
        employee.setLocation(emp.getLocation());

        return employeeRepository.save(employee);

    }

    @DeleteMapping("{id}")
    public String deleteEmplyee(@PathVariable long id){
        employeeRepository.deleteById(id);
        return new String("Employee Delete Successfully with id :"+id);
    }

}
