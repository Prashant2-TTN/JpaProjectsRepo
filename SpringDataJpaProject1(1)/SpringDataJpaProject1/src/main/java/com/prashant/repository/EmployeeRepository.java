package com.prashant.repository;

import com.prashant.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findByName(String name);

    List<Employee> findByNameStartsWith(char ch);

    List<Employee> findByAgeBetween(int min, int max);
}
