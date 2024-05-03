package org.codingsense.employee.controller;

import org.codingsense.employee.dto.EmployeeRequest;
import org.codingsense.employee.dto.EmployeeResponse;
import org.codingsense.employee.model.Employee;
import org.codingsense.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class EmployeeBackendController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getById")
    public EmployeeResponse getById(@RequestParam long id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/create")
    public String createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return employeeService.saveEmployee(employeeRequest);
    }

    @PutMapping("/update")
    public String updateEmployee(@ModelAttribute Employee employee) {
        return employeeService.updateEmployee(employee);
    }
}
