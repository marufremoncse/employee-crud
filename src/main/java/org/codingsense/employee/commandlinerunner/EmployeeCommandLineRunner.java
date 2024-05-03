package org.codingsense.employee.commandlinerunner;

import org.codingsense.employee.dto.EmployeeRequest;
import org.codingsense.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmployeeCommandLineRunner implements CommandLineRunner {
    @Autowired
    EmployeeService employeeService;
    @Override
    public void run(String... args) throws Exception {
        employeeService.saveEmployee(new EmployeeRequest("Thomas Hardy", "thomashardy@mail.com", "89 Chiaroscuro Rd, Portland, USA", "(171) 555-2222"));
        employeeService.saveEmployee(new EmployeeRequest("Dominique Perrier", "dominiqueperrier@mail.com", "Obere Str. 57, Berlin, Germany", "(313) 555-5735"));
        employeeService.saveEmployee(new EmployeeRequest("Maria Anders", "mariaanders@mail.com", "25, rue Lauriston, Paris, France", "(503) 555-9931"));
        employeeService.saveEmployee(new EmployeeRequest("Fran Wilson", "franwilson@mail.com", "C/ Araquil, 67, Madrid, Spain", "(204) 619-5731"));
        employeeService.saveEmployee(new EmployeeRequest("Martin Blank", "martinblank@mail.com", "Via Monte Bianco 34, Turin, Italy", "(480) 631-2097"));
    }
}
