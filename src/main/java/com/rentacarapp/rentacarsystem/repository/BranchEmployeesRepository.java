package com.rentacarapp.rentacarsystem.repository;

import com.rentacarapp.rentacarsystem.model.Branch;
import com.rentacarapp.rentacarsystem.model.BranchEmployee;
import com.rentacarapp.rentacarsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BranchEmployeesRepository extends JpaRepository<BranchEmployee, Long> {
    List<BranchEmployee> findByBranch(Branch branch);
    void deleteByBranchAndEmployee(Branch branch, Employee employee);

}