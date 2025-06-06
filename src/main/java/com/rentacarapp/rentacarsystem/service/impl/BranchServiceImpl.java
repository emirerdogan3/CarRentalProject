package com.rentacarapp.rentacarsystem.service.impl;

import com.rentacarapp.rentacarsystem.entity.Branch;
import com.rentacarapp.rentacarsystem.entity.User;
import com.rentacarapp.rentacarsystem.repository.BranchRepository;
import com.rentacarapp.rentacarsystem.repository.UserRepository;
import com.rentacarapp.rentacarsystem.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final UserRepository userRepository;

    @Override
    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }

    @Override
    public Branch createBranch(BranchDto branchDto) {
        User user = userRepository.findById(branchDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Branch branch = new Branch();
        branch.setUser(user);
        branch.setBranchName(branchDto.getBranchName());
        //branch.setLocation(clinicDto.getLocation());

        return branchRepository.save(branch);
    }

    @Override
    public Branch getBranchById(Long id) {
        return branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found with ID: " + id));
    }

    @Override
    public Branch updateBranch(BranchDto branchDto) {
        Branch branch = branchRepository.findById(branchDto.getBranchID())
                .orElseThrow(() -> new RuntimeException("Branch not found with ID: " + branchDto.getBranchID()));

        User user = userRepository.findById(branchDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        branch.setBranchName(branchDto.getBranchName());
        //clinic.setLocation(branchDto.getLocation());
        branch.setUser(user);

        return branchRepository.save(branch);
    }

    @Override
    public void deleteBranch(Long id) {
        branchRepository.deleteById(id);
    }
}
