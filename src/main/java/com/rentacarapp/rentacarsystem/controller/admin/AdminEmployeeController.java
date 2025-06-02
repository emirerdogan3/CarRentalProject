package com.rentacarapp.rentacarsystem.controller.admin;

import com.rentacarapp.rentacarsystem.dto.EmployeeDto;
import com.rentacarapp.rentacarsystem.entity.Branch;
import com.rentacarapp.rentacarsystem.entity.BranchEmployee;
import com.rentacarapp.rentacarsystem.entity.Employee;
import com.rentacarapp.rentacarsystem.entity.User;
import com.rentacarapp.rentacarsystem.repository.BranchRepository;
import com.rentacarapp.rentacarsystem.repository.UserRepository;
import com.rentacarapp.rentacarsystem.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/admin/employees")
@RequiredArgsConstructor
public class AdminEmployeeController {

    private final EmployeeService employeeService;
    private final UserRepository userRepository;
    private final BranchRepository branchRepository;
    private final com.rentacarapp.rentacarsystem.repository.BranchEmployeesRepository branchEmployeesRepository;
    private final com.rentacarapp.rentacarsystem.service.BranchService branchService;

    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("users", userRepository.findByRoleRoleName("EMPLOYEE"));
        //model.addAttribute("branches", branchRepository.findAll());
        return "admin/employees";
    }

    @PostMapping("/create")
    public String createEmployee(@RequestParam String firstName,
                                   @RequestParam String lastName,
                                   @RequestParam BigDecimal salary,
                                   @RequestParam Integer shiftCount,
                                   @RequestParam String positionTitle,
                                   @RequestParam Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Employee employee = Employee.builder()
                .firstName(firstName)
                .lastName(lastName)
                .salary(salary)
                .salary(salary)
                .shiftCount(shiftCount)
                .positionTitle(positionTitle)
                .user(user)
                .build();

        employeeService.createEmployeeFromEntity(employee);
        return "redirect:/admin/employees";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/admin/employees";
    }

    @GetMapping("/edit/{id}")
    public String editEmployeeForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeEntityById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("users", userRepository.findByRoleRoleName("EMPLOYEE"));
        return "admin/edit_employee";
    }

    @PostMapping("/update")
    public String updateEmployee(@RequestParam Long employeeID,
                                 @RequestParam String firstName,
                                 @RequestParam String lastName,
                                 @RequestParam BigDecimal salary,
                                 @RequestParam Integer shiftCount,
                                 @RequestParam String positionTitle,
                                 @RequestParam Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Employee emp = employeeService.getEmployeeEntityById(employeeID);
        emp.setFirstName(firstName);
        emp.setLastName(lastName);
        emp.setSalary(salary);
        emp.setShiftCount(shiftCount);
        emp.setPositionTitle(positionTitle);
        emp.setUser(user);

        employeeService.updateEmployeeEntity(emp);
        return "redirect:/admin/employees";
    }

    @GetMapping("/admin/employees/create")
    public String showCreateEmployeeForm(Model model) {
        List<Branch> branches = branchService.getAllBranches();  // tüm branch'leri çek
        model.addAttribute("branches", branches);                // JSP'ye gönder
        model.addAttribute("employee", new EmployeeDto());       // form için boş DTO
        return "admin/employee-form";                            // JSP sayfa adı
    }


    @GetMapping("/{id}/assign-branch")
    public String assignBranchForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeEntityById(id);
        List<Branch> branch = branchRepository.findAll();
        model.addAttribute("employee", employee);
        model.addAttribute("branches", branch);
        return "admin/assign_branch_to_emp";
    }

    @PostMapping("/{id}/assign-branch")
    public String assignBranchToEmp(@PathVariable Long id, @RequestParam Long branchID) {
        Employee employee = employeeService.getEmployeeEntityById(id);
        Branch branch = branchRepository.findById(branchID).orElseThrow();

        BranchEmployee cv = new BranchEmployee();
        cv.setBranch(branch);
        cv.setEmployee(employee);

        branchEmployeesRepository.save(cv);
        return "redirect:/admin/employees";
    }


}