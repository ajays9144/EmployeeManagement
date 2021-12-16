package com.capco.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class SearchParam {
    /**
     * searchBy identify search based 'First Name' and 'Last Name'
     * Accept Two Value 'firstName' or 'lastName'
     */
    private String searchBy;
    /**
     * Use for search name from Employee Table
     */
    private String name;
    /**
     * Optional value for Sorting Order which have 'ASC'(ASCENDING) OR 'DESC'(DESCENDING)
     */
    private String orderBy;
}
