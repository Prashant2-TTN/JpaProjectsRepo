package com.prashnant.InheritanceMapping;

import com.prashnant.InheritanceMapping.entity.Card;
import com.prashnant.InheritanceMapping.entity.Check;
import com.prashnant.InheritanceMapping.entity.EmployeeEmbedded;
import com.prashnant.InheritanceMapping.entity.EmployeeEmbedded;
import com.prashnant.InheritanceMapping.entity.Salary;
import com.prashnant.InheritanceMapping.repository.EmployeeRepository;
import com.prashnant.InheritanceMapping.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InheritanceMappingApplicationTests {
	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

	//-------------------------- SINGLE CLASS TEST-----------------------------------------
	@Test
	public void makeCardPayment() {
		Card card = new Card();
		card.setCardNumber(12345678);
		card.setAmount(25000);
		card.setId(101);
		paymentRepository.save(card);
	}

	@Test
	public void makeCheckPayment(){
		Check check =new Check();
		check.setCheckNumber(12345678);
		check.setAmount(25000);
		check.setId(102);
		paymentRepository.save(check);
	}

	//----------------------- JOINED TESTs---------------------------


	@Test
	public void makeCardPaymentJoined() {
		Card card = new Card();
		card.setCardNumber(12345678);
		card.setAmount(25000);
		card.setId(101);
		paymentRepository.save(card);
	}
	@Test
	public void makeCheckPaymentJoined(){
		Check check =new Check();
		check.setCheckNumber(2345678);
		check.setAmount(45000);
		check.setId(102);
		paymentRepository.save(check);
	}

	//---------------------------- Class per table -----------------------------------

	@Test
	public void makeCardPaymentPerTable(){
		Card card =new Card();
		card.setCardNumber(12345678);
		card.setAmount(25000);
		card.setId(101);
		paymentRepository.save(card);
	}
	@Test
	public void makeCheckPaymentPerTable(){
		Check check =new Check();
		check.setCheckNumber(12345678);
		check.setAmount(25000);
		check.setId(101);
		paymentRepository.save(check);
	}

	// ------------------------------ Component Mapping tests ------------------------------

	@Test
	public void createEmployee(){
		EmployeeEmbedded employee = new EmployeeEmbedded();
		employee.setAge(27);
		employee.setFirstName("Devansh");
		employee.setLastName("Gupta");
		employee.setId(1);
		Salary salary = new Salary();
		salary.setBasicSalary(25000);
		salary.setBonusSalary(15000);
		salary.setTaxAmount(5000);
		salary.setSpecialAllowanceSalary(7000);
		employee.setSalary(salary);

		employeeRepository.save(employee);
	}


}
