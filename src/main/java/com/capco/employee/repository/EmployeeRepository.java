package com.capco.employee.repository;

import com.capco.employee.entity.EmployeeEntity;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Making connection between Service and Database.
 * Find data according to our requirement.
 * */
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    /**
    * Find Employee By Id
    * */
    Optional<EmployeeEntity> findByEmployeeId(String employeeNumber);


    /**
     * Find Employee Details based on 'First Name' also using ascending order on name
     * */
    @Query(value = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE.FIRSTNAME like %:firstName% ORDER BY EMPLOYEE.FIRSTNAME ASC", nativeQuery = true)
    List<EmployeeEntity> findEmployeeByFirstName(String firstName);

    /**
     * Find Employee Details based on 'Last Name' also using ascending order on name
     * */
    @Query(value = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE.LASTNAME like %:lastName% ORDER BY EMPLOYEE.LASTNAME ASC", nativeQuery = true)
    List<EmployeeEntity> findEmployeeByLastName(String lastName);
}
