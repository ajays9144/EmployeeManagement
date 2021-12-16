# Employee
Run Command:- mvn spring-boot-run -pl employee or Run com.capco.employee.EmployeeApplication file with any IDE.

Already Enabled Swagger API based documentation will get on URL:- http://localhost:8080/swagger-ui.html. Execute this URL on Browser when Server is running mode.

In Controller, Find API endpoints.

1. URL:- http://localhost:8080/1.0/employee,  Method:- GET
    Response:- All Employee List
   
2. URL:- http://localhost:8080/1.0/employee/{employeeId}, Method:- GET
    Response:- Get Employee Details by 'Employee Id'
   
3. URL:- http://localhost:8080/1.0/employee/{employeeId} Method:- PUT
    Consume:- Employee Id As Path Variable in URL and Employee Details want to update
    Response:- Updated Employee Details.
   
4. URL:- http://localhost:8080/1.0/employee/search-employee Method:- POST
    Consume:- SearchParam which contain 'SearchBy', 'Name' and 'orderBy'(Which is optional from user)
    And here 'orderBy' Accept only 'ASC' OR 'DESC' which not case-sensitive.
    Response:- Return Matched Name of List for the Employee Details. 