package com.rentacarapp.rentacarsystem.service;

import com.rentacarapp.rentacarsystem.dto.BranchDto;
import com.rentacarapp.rentacarsystem.entity.Branch;

import java.util.List;

public interface BranchService {
    List<Branch> getAllBranches();
    Branch getBranchById(Long id);
    Branch createBranch(BranchDto branchDto);
    Branch updateBranch(BranchDto branchDto);
    void deleteBranch(Long id);
}
