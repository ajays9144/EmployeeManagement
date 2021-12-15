package com.capco.employee.service;

import com.capco.employee.entity.EmployeeEntity;
import com.capco.employee.error.IdNotFoundException;
import com.capco.employee.model.Employee;
import com.capco.employee.model.SearchParam;
import com.capco.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementation for Employee Service Class
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    /**
     * Get Employee Get based on 'Employee Id' from Employee Repository,
     * Using Optional Class here If in case found null data.
     * Mapped 'Employee Entity Class to 'Employee' Object, Response Excepted in Employee Class
     */
    @Override
    public Employee getEmployee(String employeeId) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findByEmployeeId(employeeId);
        if (employeeEntity.isPresent()) {
            EmployeeEntity entity = employeeEntity.get();
            return new Employee(entity.getEmployeeId(), entity.getFirstname(), entity.getLastname());
        }
        throw new IdNotFoundException("Employee Id Not Found: " + employeeId);
    }

    /**
     * Find All Employee Details from Employee Repository,
     * Mapped 'Employee Entity Class to 'Employee' Object, Response Excepted in Employee Class
     */
    @Override
    public List<Employee> getAllEmployee() {
        Iterable<EmployeeEntity> employeeEntity = employeeRepository.findAll();
        ArrayList<Employee> employees = new ArrayList<>();
        for (EmployeeEntity entity : employeeEntity) {
            employees.add(new Employee(entity.getEmployeeId(), entity.getFirstname(), entity.getLastname()));
        }
        return employees;
    }

    /**
     * Update Employee Details, Find Employee from Table With 'Employee Id'
     * If not able to find any Employee Based On 'Employee id' throw Exception
     * Else it update Employee Details with help of 'Employee Entity'
     * */
    @Override
    public Employee updateEmployee(Employee employee, String employeeId) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findByEmployeeId(employeeId);
        if (employeeEntity.isPresent()) {
            EmployeeEntity entity = employeeEntity.get();
            entity.setFirstname(employee.getFirstName());
            entity.setLastname(employee.getLastName());
            employeeRepository.save(entity).getEmployeeId().equals(employeeId);
            return new Employee(entity.getEmployeeId(), entity.getFirstname(), entity.getLastname());
        }
        throw new IdNotFoundException("Employee Id Not Found: " + employeeId);
    }

    /**
     * Search Employee based on 'Search Param' Object Class
     * Check 'SearchBy' Param value from 'Search param' Object and based on that Call two different Methods.
     * Found Result from Repository mapped with Employee Object with help Iterate.
     * */
    @Override
    public List<Employee> getEmployeeByName(SearchParam searchParam) {
        if (searchParam.getSearchBy().equalsIgnoreCase("firstName")) {
            List<EmployeeEntity> employeeEntity = employeeRepository.findEmployeeByFirstName(searchParam.getName());
            if (employeeEntity != null) {
                ArrayList<Employee> employees = new ArrayList<>();
                for (EmployeeEntity entity : employeeEntity) {
                    employees.add(new Employee(entity.getEmployeeId(), entity.getFirstname(), entity.getLastname()));
                }
                return employees;
            }
        } else {
            List<EmployeeEntity> employeeEntity = employeeRepository.findEmployeeByLastName(searchParam.getName());
            if (employeeEntity != null) {
                ArrayList<Employee> employees = new ArrayList<>();
                for (EmployeeEntity entity : employeeEntity) {
                    employees.add(new Employee(entity.getEmployeeId(), entity.getFirstname(), entity.getLastname()));
                }
                return employees;
            }
        }
        throw new IdNotFoundException("Employee Name Not Found: " + searchParam.getName());
    }
}
