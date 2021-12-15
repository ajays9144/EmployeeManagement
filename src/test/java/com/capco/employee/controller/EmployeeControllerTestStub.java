package com.capco.employee.controller;

import com.capco.employee.model.Employee;
import com.capco.employee.model.SearchParam;
import com.capco.employee.service.EmployeeService;
import com.capco.employee.service.EmployeeServiceStub;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class EmployeeControllerTestStub {

    @Test
    public void testEmployeeById() {
        EmployeeService employeeServiceStud = new EmployeeServiceStub();
        EmployeeController employeeController = new EmployeeController(employeeServiceStud);
        ResponseEntity<Employee> employee = employeeController.getEmployee("001000");
        assertNotNull(employee.getBody());
    }

    @Test
    public void testAllEmployee() {
        EmployeeService employeeServiceStud = new EmployeeServiceStub();
        EmployeeController employeeController = new EmployeeController(employeeServiceStud);
        ResponseEntity<List<Employee>> employee = employeeController.getAllEmployee();
        assertEquals(5, employee.getBody().size());
    }

    @Test
    public void updateEmployeeDetails() {
        EmployeeService employeeServiceStud = new EmployeeServiceStub();
        EmployeeController employeeController = new EmployeeController(employeeServiceStud);
        Employee employee = new Employee("001000", "Christian", "Bell");
        ResponseEntity<Employee> updateEmployee = employeeController.updateEmployee(employee, "001000");
        assertNotNull(updateEmployee.getBody());
    }

    @Test
    public void findEmployeeDetailsByName() {
        EmployeeService employeeServiceStud = new EmployeeServiceStub();
        EmployeeController employeeController = new EmployeeController(employeeServiceStud);
        SearchParam searchParam = new SearchParam("firstName", "Tom");
        ResponseEntity<List<Employee>> employee = employeeController.searchEmployee(searchParam);
        assertEquals(2, employee.getBody().size());
    }
}
