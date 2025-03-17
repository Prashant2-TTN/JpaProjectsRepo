package com.prashant.jpa2.SpringDataJpaAssignment2.repository;

import com.prashant.jpa2.SpringDataJpaAssignment2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {



    @Query("select firstName, lastName from  Employee where salary > (select avg(salary) from Employee) order by age asc, salary desc")
    List<Object[]> getEmployeesByCondition1();

    @Query("select avg(salary) from Employee")
    Double getAvgSalary();

    @Modifying
    @Query(value = "update Employee set salary=:salary where salary<:avg_salary")
    void updateSalary(@Param("avg_salary") double avg_salary, @Param("salary") int salary);


    @Modifying
    @Query("delete from Employee where salary = (select minimum from (select min(salary) as minimum from Employee) as table1)")
    void deleteMinSalaryEmployee();


    //--------------------------------- native query -----------------------------------------------

    @Query(value = "select emp_Id , emp_first_name , emp_age from employee_table where emp_last_name='singh'",nativeQuery = true)
     List<Object[]> findAllEmployeesByLastnameSingh();

    @Modifying
    @Query(value = "delete from  employee_table where emp_age>:age",nativeQuery=true)
    void deleteAllEmployeesAgedGreaterThan45(@Param("age") int age);
}

