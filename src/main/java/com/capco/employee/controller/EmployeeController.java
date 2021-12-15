package com.capco.employee.controller;

import com.capco.employee.model.Employee;
import com.capco.employee.model.SearchParam;
import com.capco.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/1.0/employee")
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("employeeId") String employeeId) {
        Employee employee = employeeService.getEmployee(employeeId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("employeeId") String employeeId) {
        Employee updateEmployee = employeeService.updateEmployee(employee, employeeId);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @PostMapping("/search-employee")
    public ResponseEntity<List<Employee>> searchEmployee(@RequestBody SearchParam searchParam) {
        List<Employee> employee = employeeService.getEmployeeByName(searchParam);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
