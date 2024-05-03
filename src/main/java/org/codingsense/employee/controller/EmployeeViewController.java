package org.codingsense.employee.controller;

import org.codingsense.employee.dto.EmployeeRequest;
import org.codingsense.employee.model.Employee;
import org.codingsense.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class EmployeeViewController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/")
    public String employeeViewHandler(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("employeeRequest",new EmployeeRequest());
        model.addAttribute("emptyEmployee",new Employee());
        return "employee";
    }

    @PostMapping("/create")
    public String createEmployee(@ModelAttribute EmployeeRequest employeeRequest, Model model) {
        model.addAttribute("employeeRequest",new EmployeeRequest());
        employeeService.saveEmployee(employeeRequest);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute Employee employee, Model model) {
        employeeService.updateEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }



}
