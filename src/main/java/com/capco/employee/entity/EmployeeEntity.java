package com.capco.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Entity Class use for create a table and column within table
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity {
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private long id;
    @Column(name = "EMPLOYEE_ID", unique = true, nullable = false)
    private String employeeId;
    @Column(name = "FIRSTNAME", nullable = false)
    private String firstname;
    @Column(name = "LASTNAME", nullable = false)
    private String lastname;
}



