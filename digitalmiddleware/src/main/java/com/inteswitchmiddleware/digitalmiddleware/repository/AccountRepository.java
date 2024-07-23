package com.inteswitchmiddleware.digitalmiddleware.repository;

import com.inteswitchmiddleware.digitalmiddleware.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByAccountNumber(String accountNumber);

    Account findByCustomerId(Long customerId);
}
