package com.example.employeemanagment;

import com.example.employeemanagment.model.Employee;
import com.example.employeemanagment.model.Manager;
import com.example.employeemanagment.repository.EmployeeRepository;
import com.example.employeemanagment.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ManagerRepository managerRepository;

	@Override
	public void run(String... args) throws Exception {

		Employee employee = new Employee();

		employee.setEmpName("Ganesh");
		employee.setLocation("Pune");

		employeeRepository.save(employee);

		Manager manager = new Manager();
		manager.setMName("Cena");
		managerRepository.save(manager);

	}
}
