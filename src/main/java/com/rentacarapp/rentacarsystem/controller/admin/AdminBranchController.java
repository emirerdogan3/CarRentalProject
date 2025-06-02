package com.rentacarapp.rentacarsystem.controller.admin;


import com.rentacarapp.rentacarsystem.dto.BranchDto;
import com.rentacarapp.rentacarsystem.entity.Branch;
import com.rentacarapp.rentacarsystem.entity.BranchEmployee;
import com.rentacarapp.rentacarsystem.entity.Employee;
import com.rentacarapp.rentacarsystem.repository.BranchEmployeesRepository;
import com.rentacarapp.rentacarsystem.repository.UserRepository;
import com.rentacarapp.rentacarsystem.service.BranchService;
import com.rentacarapp.rentacarsystem.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/branches")
@RequiredArgsConstructor
public class AdminBranchController {


    private final BranchService branchService;
    private final UserRepository userRepository;
    private final EmployeeService employeeService;
    private final BranchEmployeesRepository branchEmployeesRepository;

    @GetMapping
    public String showBranches(Model model) {
        model.addAttribute("branches", branchService.getAllBranches());
        model.addAttribute("users", userRepository.findByRoleRoleName("BRANCH"));
        return "admin/branches";
    }

    @PostMapping("/create")
    public String createBranch(@ModelAttribute BranchDto branchDto) {
        branchService.createBranch(branchDto);
        return "redirect:/admin/branches";
    }

    @PostMapping("/delete/{id}")
    public String deleteBranch(@PathVariable("id") long id) {
        branchService.deleteBranch(id);
        return "redirect:/admin/branches";
    }

    @GetMapping("/edit/{id}")
    public String editBranchForm(@PathVariable Long id, Model model) {
        model.addAttribute("branch", branchService.getBranchById(id));
        model.addAttribute("users", userRepository.findByRoleRoleName("BRANCH"));
        return "admin/edit_branch";
    }

    @PostMapping("/update")
    public String updateBranch(@ModelAttribute BranchDto branchDto) {
        branchService.updateBranch(branchDto);
        return "redirect:/admin/branches";
    }

    @GetMapping("/{id}/employees")
    public String listBranchEmployees(@PathVariable Long id, Model model) {
        Branch branch = branchService.getBranchById(id);
        List<BranchEmployee> assigned = branchEmployeesRepository.findByBranch(branch);

        model.addAttribute("branch", branch);
        model.addAttribute("assignedEmployees", assigned);
        model.addAttribute("allEmployees", employeeService.getAllEmployeeEntities());
        return "admin/branch_employees";
    }

    @PostMapping("/{branchID}/employees/assign")
    public String assignEmployeeToBranch(@PathVariable Long branchID,
                                           @RequestParam Long employeeID) {
        Branch branch = branchService.getBranchById(branchID);
        Employee emp = employeeService.getEmployeeEntityById(employeeID);

        BranchEmployee relation = BranchEmployee.builder()
                .branch(branch)
                .employee(emp)
                .build();

        branchEmployeesRepository.save(relation);

        return "redirect:/admin/branches/" + branchID + "/employees";
    }

    @PostMapping("/{branchID}/employees/remove/{employeeID}")
    @Transactional
    public String removeEmployeeFromBranch(@PathVariable Long branchID,
                                             @PathVariable Long employeeID) {
        Branch branch = branchService.getBranchById(branchID);
        Employee emp = employeeService.getEmployeeEntityById(employeeID);

        branchEmployeesRepository.deleteByBranchAndEmployee(branch, emp);

        return "redirect:/admin/branches/" + branchID + "/employees";
    }
}
