package com.rentacarapp.rentacarsystem.service;

import com.rentacarapp.rentacarsystem.dto.EmployeeDto;
import com.rentacarapp.rentacarsystem.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {

    // Admin tarafının kontrolleri (Cenkin VeterinaryService kısmından alındı)
    Employee createEmployeeFromEntity(Employee employee);
    Employee getEmployeeEntityById(Long id);
    Employee updateEmployeeEntity(Employee employee);
    List<Employee> getAllEmployeeEntities();

    // Benim VeterinaryService için yaptığım kısımlar
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);
    void deleteEmployee(Long id);


    // Login işlemi
    ResponseEntity<?> login(String username, String password);

}
