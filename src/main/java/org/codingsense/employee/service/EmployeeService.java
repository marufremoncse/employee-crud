package org.codingsense.employee.service;

import org.codingsense.employee.dto.EmployeeRequest;
import org.codingsense.employee.dto.EmployeeResponse;
import org.codingsense.employee.model.Employee;
import org.codingsense.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeResponse getEmployee(Long id){
        Employee byId = employeeRepository.getById(id);
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(byId.getId());
        employeeResponse.setName(byId.getName());
        employeeResponse.setAddress(byId.getAddress());
        employeeResponse.setPhone(byId.getPhone());
        employeeResponse.setEmail(byId.getEmail());

        return employeeResponse;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public String saveEmployee(EmployeeRequest employeeRequest){
        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setAddress(employeeRequest.getAddress());
        employee.setPhone(employeeRequest.getPhone());
        employeeRepository.save(employee);
        return "employee is created successfully";
    }
    public String updateEmployee(Employee employee){
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());
        if(optionalEmployee.isPresent()){
            employeeRepository.save(employee);
            return "employee is updated successfully";
        }
        return "employee not found";
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
}
