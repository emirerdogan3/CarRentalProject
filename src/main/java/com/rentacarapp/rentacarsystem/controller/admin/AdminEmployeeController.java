package com.rentacarapp.rentacarsystem.controller.admin;

import com.rentacarapp.rentacarsystem.model.Employee;
import com.rentacarapp.rentacarsystem.model.User;
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
    //private final ClinicRepository clinicRepository;
    //private final com.rentacarapp.rentacarsystem.repository.ClinicVeterinaryRepository clinicVeterinaryRepository;


    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("users", userRepository.findByRoleRoleName("EMPLOYEE"));
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
        model.addAttribute("employees", employee);
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

    /**
    @GetMapping("/{id}/assign-branch")
    public String assignBranchForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeEntityById(id);
        List<Branchs> branchs = branchRepository.findAll();
        model.addAttribute("employee", employee);
        model.addAttribute("branchs", branchs);
        return "admin/assign_branch_to_emp";
    }

    @PostMapping("/{id}/assign-clinic")
    public String assignClinicToVet(@PathVariable Long id, @RequestParam Long clinicId) {
        Veterinary veterinary = veterinaryService.getVeterinaryEntityById(id);
        Clinic clinic = clinicRepository.findById(clinicId).orElseThrow();

        ClinicVeterinary cv = new ClinicVeterinary();
        cv.setClinic(clinic);
        cv.setVeterinary(veterinary);

        clinicVeterinaryRepository.save(cv);
        return "redirect:/admin/veterinaries";
    }
    */

}