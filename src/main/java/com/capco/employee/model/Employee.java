package com.capco.employee.model;

import lombok.Value;

/**
 * Class for Response.
 * Implement Comparable Interface for Sorting result based on Requirement.
 */
@Value
public class Employee implements Comparable<Employee> {
    /**
     * Employee Id
     */
    String userId;
    /**
     * Employee First Name
     */
    String firstName;
    /**
     * Employee Last Name
     */
    String lastName;


    /**
     * Comparing data based Employee 'First Name'
     * */
    @Override
    public int compareTo(Employee o) {
        return firstName.compareTo(o.getFirstName());
    }
}
