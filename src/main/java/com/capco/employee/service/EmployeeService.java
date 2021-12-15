package com.capco.employee.service;

import com.capco.employee.model.Employee;
import com.capco.employee.model.SearchParam;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface EmployeeService
{
    /**
     * Service for Get Employee Details by Employee ID
     * */
    Employee getEmployee(String employeeId);

    /**
     * Service for Get All Employee
     * */
    List<Employee> getAllEmployee();

    /**
     * Service for update Employee Details when Employee Id match
     * */
    Employee updateEmployee(Employee employee, String employeeId);

    /**
     * Service for find Employee Details based on Name
     * */
    List<Employee> getEmployeeByName(SearchParam searchParam);
}
