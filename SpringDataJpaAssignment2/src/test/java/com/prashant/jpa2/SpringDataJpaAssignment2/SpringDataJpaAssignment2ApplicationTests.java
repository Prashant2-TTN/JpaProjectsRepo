package com.prashant.jpa2.SpringDataJpaAssignment2;

import com.prashant.jpa2.SpringDataJpaAssignment2.entity.Employee;
import com.prashant.jpa2.SpringDataJpaAssignment2.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringDataJpaAssignment2ApplicationTests {

	Logger LOGGER = LoggerFactory.getLogger(SpringDataJpaAssignment2ApplicationTests.class);
	 @Autowired
	EmployeeRepository employeeRepository;
	@Test
	void contextLoads() {
	}
	@Test
	public void createEmployees(){
		Employee employee = new Employee();
		employee.setAge(51);
		employee.setFirstName("Mithun ");
		employee.setLastName("Chakrabarty");
		employee.setSalary(85000);
		employeeRepository.save(employee);

	Employee employee2 = new Employee();
		employee2.setAge(48);
		employee2.setFirstName("Rajesh");
		employee2.setLastName("Khanna");
		employee2.setSalary(75000);

		employeeRepository.save(employee2);

	}

	@Test
	public void display(){
		System.out.println(employeeRepository.findAll());
	}

	@Test
	public void filterEmployees(){
		List<Object[]> list =employeeRepository.getEmployeesByCondition1();
		for(Object[] arr :list){
			System.out.println(arr[0]+" "+arr[1]);
		}
	}

	@Transactional
	@Test
	@Rollback(value = false)
	public void updateEmployeesWithPassedSalary(){
		Double avg_salary=employeeRepository.getAvgSalary();
		employeeRepository.updateSalary(avg_salary, 49500);

	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void deleteEmployee(){
		employeeRepository.deleteMinSalaryEmployee();

	}

	@Test
	public void findByLastName(){
		List<Object[]> list= employeeRepository.findAllEmployeesByLastnameSingh();

		for(Object [] arr : list){
			System.out.println(" id : "+arr[0]+" first name : "+arr[1]+" age : "+arr[2]);
		}
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void deleteEmployeesByAge(){
		employeeRepository.deleteAllEmployeesAgedGreaterThan45(45);
	}
}
