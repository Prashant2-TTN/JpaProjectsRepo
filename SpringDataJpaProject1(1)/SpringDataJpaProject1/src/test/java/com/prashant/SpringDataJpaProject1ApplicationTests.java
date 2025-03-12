package com.prashant;

import com.prashant.entity.Employee;
import com.prashant.repository.EmployeeRepository;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;


@SpringBootTest
//@RunWith(SpringRunner.class)
class SpringDataJpaProject1ApplicationTests {
	final EmployeeRepository employeeRepository;
    @Autowired
	public SpringDataJpaProject1ApplicationTests(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Test
	public void createEmployees(){
		for(int i=1;i<=10;i++){
			Employee e=new Employee();
			e.setLocation("location"+i);
			e.setName("name"+i);
			e.setAge(30+i);
			employeeRepository.save(e);
		}
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void createTest(){
		Employee employee=new Employee();
		employee.setAge(23);
		employee.setName("Anant");
		employee.setLocation("Delhi");
		employeeRepository.save(employee);

	}

	@Test
	public void updateTest(){
		if(employeeRepository.existsById(16))
		{
			Employee employee= employeeRepository.findById(16).get();
			employee.setName("Maharana Pratap Singh");
			employeeRepository.save(employee);
		}
	}

	@Test
	public void deleteTest(){
		employeeRepository.deleteById(17);
	}

	@Test
	public void readTest(){
		System.out.println(employeeRepository.findById(16).get());
	}

	@Test
	public void countTest(){
		System.out.println("Total no of employees : "+employeeRepository.count());
	}


	@Test
	public void paginationAndSorting(){
		Pageable pageable= PageRequest.of(0,3, Sort.by(Sort.Direction.DESC,"age"));
		Page<Employee> page= employeeRepository.findAll(pageable);
		page.forEach(emp-> System.out.println(emp));

	}

	@Test
	public void finderFindByName(){
		List<Employee> list= employeeRepository.findByName("Maharana Pratap Singh");
		list.forEach(emp-> System.out.println(emp));
	}

	@Test
	public void finderFindByNameStartsWith(){
		List<Employee> list= employeeRepository.findByNameStartsWith('n');
		list.forEach(emp-> System.out.println(emp));
	}

	@Test
	public void findByAgeBetween(){
		List<Employee> list= employeeRepository.findByAgeBetween(28,32);
		list.forEach(emp-> System.out.println(emp));
	}
}
