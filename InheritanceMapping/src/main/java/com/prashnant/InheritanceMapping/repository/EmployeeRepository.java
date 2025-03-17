package com.prashnant.InheritanceMapping.repository;

import com.prashnant.InheritanceMapping.entity.EmployeeEmbedded;
import com.prashnant.InheritanceMapping.entity.EmployeeEmbedded;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEmbedded,Integer> {
}
