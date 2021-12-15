package com.capco.employee;

import com.capco.employee.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {

	}

}
