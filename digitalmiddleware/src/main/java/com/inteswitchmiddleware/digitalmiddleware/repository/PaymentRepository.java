package com.inteswitchmiddleware.digitalmiddleware.repository;

import com.inteswitchmiddleware.digitalmiddleware.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
