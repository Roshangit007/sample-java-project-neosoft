package com.example.employeemanagment.controller;

import com.example.employeemanagment.model.Manager;
import com.example.employeemanagment.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/ems")
public class ManagerController {
    @Autowired
    private ManagerRepository managerRepository;

    @GetMapping("/allmanager")
    public List<Manager> getAllManager(){
        return managerRepository.findAll();
    }

    @GetMapping("{id}")
    public Manager getManagerById(@PathVariable long id){
        return managerRepository.findById(id).orElseThrow(()-> new RuntimeException());
    }

    @PostMapping("/posts")
    public Manager postManagerDetails(@RequestBody Manager manager){
        return managerRepository.save(manager);
    }

    @PutMapping("/updatemanager/{id}")
    public Manager updateManagerDetails(@RequestBody Manager manager , @PathVariable long id){
        Manager mg = managerRepository.findById(id).orElseThrow(()-> new RuntimeException());
        mg.setMName(manager.getMName());

        return  managerRepository.save(mg);
    }

}
