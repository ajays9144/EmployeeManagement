package com.capco.employee.model;

import lombok.Value;

/**
 * Class for Response.
 * */
@Value
public class Employee
{
    /**
    * Employee Id
    * */
    String userId;
    /**
     * Employee First Name
     * */
    String firstName;
    /**
     * Employee Last Name
     * */
    String lastName;
}
