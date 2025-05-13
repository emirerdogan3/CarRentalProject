package com.rentacarapp.rentacarsystem.service.impl;

import com.rentacarapp.rentacarsystem.dto.EmployeeDto;
import com.rentacarapp.rentacarsystem.model.Employee;
import com.rentacarapp.rentacarsystem.repository.EmployeeRepository;
import com.rentacarapp.rentacarsystem.repository.UserRepository;
import com.rentacarapp.rentacarsystem.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Employee createEmployeeFromEntity(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeEntityById(Long id) {
        return null;
    }

    @Override
    public Employee updateEmployeeEntity(Employee employee) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployeeEntities() {
        return List.of();
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        return null;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return List.of();
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {

    }

    @Override
    public ResponseEntity<?> login(String username, String password) {
        return null;
    }

    // Diğer metotları da burada override edin...
}