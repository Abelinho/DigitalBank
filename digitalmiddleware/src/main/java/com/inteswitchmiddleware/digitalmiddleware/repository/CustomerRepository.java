package com.inteswitchmiddleware.digitalmiddleware.repository;

import com.inteswitchmiddleware.digitalmiddleware.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
