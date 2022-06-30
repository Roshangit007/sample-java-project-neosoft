package com.example.employeemanagment.repository;

import com.example.employeemanagment.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager,Long> {

}
