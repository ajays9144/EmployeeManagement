package com.capco.employee.service;

import com.capco.employee.model.Employee;
import com.capco.employee.model.SearchParam;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceStub implements EmployeeService {

    @Override
    public Employee getEmployee(String employeeId) {
        Employee updateEmployee = new Employee("001000", "Bruce", "Wayne");
        if (updateEmployee.getUserId().equals("001000")) {
            return new Employee("001000", "Bruce", "Wayne");
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return getEmployeeList();
    }

    @Override
    public Employee updateEmployee(Employee employee, String employeeId) {
        Employee updateEmployee = new Employee("001000", "Bruce", "Wayne");
        if (updateEmployee.getUserId().equals(employeeId)) {
            return updateEmployee;
        }
        return null;
    }

    @Override
    public List<Employee> getEmployeeByName(SearchParam searchParam) {
        ArrayList<Employee> employees = new ArrayList<>(getEmployeeList());
        ArrayList<Employee> filterList = new ArrayList<>();
        for (Employee employee : employees) {
            if (searchParam.getSearchBy().equals("firstName")) {
                if (employee.getFirstName().startsWith(searchParam.getName())) {
                    filterList.add(employee);
                }
            } else if (searchParam.getSearchBy().equals("lastName")) {
                if (employee.getLastName().startsWith(searchParam.getName())) {
                    filterList.add(employee);
                }
            }
        }
        return filterList;
    }

    private List<Employee> getEmployeeList() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("001015", "Tony", "Stark"));
        employees.add(new Employee("001010", "Tom", "Moody"));
        employees.add(new Employee("001011", "Tom", "Riddle"));
        employees.add(new Employee("001013", "Peter", "Parker"));
        employees.add(new Employee("001014", "Jason", "Smith"));
        return employees;
    }
}
