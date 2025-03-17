package com.prashnant.InheritanceMapping.repository;

import com.prashnant.InheritanceMapping.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository  extends JpaRepository<Payment,Integer> {
}
