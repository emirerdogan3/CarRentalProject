package com.rentacarapp.rentacarsystem.service.impl;

import com.rentacarapp.rentacarsystem.dto.EmployeeDTO;
import com.rentacarapp.rentacarsystem.entity.Employee;
import com.rentacarapp.rentacarsystem.entity.User;
import com.rentacarapp.rentacarsystem.repository.EmployeeRepository;
import com.rentacarapp.rentacarsystem.repository.UserRepository;
import com.rentacarapp.rentacarsystem.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public EmployeeDTO createEmployee(EmployeeDTO employeeDto) {
        User user = userRepository.findByUsername(employeeDto.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found!"));

        Employee employee = modelMapper.map(employeeDto, Employee.class);
        employee.setUser(user);

        Employee savedEmployee = employeeRepository.save(employee);

        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found!"));
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    //  Employee listelemede branch usernamei görünmesi için yapılan değişiklikten önceki hali
    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(vet -> {
                    EmployeeDTO dto = modelMapper.map(vet, EmployeeDTO.class);
                    dto.setUsername(vet.getUser().getUsername());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    /*
    // Employee listelemede branch usernamei görünmesi için yapılan değişiklikten sonraki hali
    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(emp -> {
                    EmployeeDto dto = modelMapper.map(emp, EmployeeDto.class);
                    dto.setUsername(emp.getUser().getUsername());

                    if (emp.getBranch() != null && emp.getBranch().getUser() != null) {
                        dto.setBranchName(emp.getBranch().getUser().getUsername());
                    }

                    return dto;
                })
                .collect(Collectors.toList());
    }*/



    @Override
    public List<Employee> getAllEmployeeEntities() {
        return employeeRepository.findAll();
    }


    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDto) {
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<?> login(String username, String password) {
        return null;
    }

    @Override
    public Employee createEmployeeFromEntity(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeEntityById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public Employee updateEmployeeEntity(Employee employee) {
        return employeeRepository.save(employee);
    }
}