package com.inteswitchmiddleware.digitalmiddleware;

import com.inteswitchmiddleware.digitalmiddleware.entity.*;
import com.inteswitchmiddleware.digitalmiddleware.repository.*;
//import com.inteswitchmiddleware.digitalmiddleware.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;

@SpringBootApplication
//@EnableDiscoveryClient
public class DigitalmiddlewareApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private BankRepository bankRepository;

	@Autowired
	private BillCategoryRepository billCategoryRepository;

	@Autowired
	private BillerRepository billerRepository;

	@Autowired
	private ProductRepository productRepository;

//	@Autowired
//	private UserDetailsServiceImpl userDetailsService;

	public static void main(String[] args) {
		SpringApplication.run(DigitalmiddlewareApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Preload Customer and Account data
		Customer customer1 = new Customer();
		customer1.setFirstName("John");
		customer1.setLastName("Doe");
		customer1.setBvn("12345678901");
		customer1.setNin("987654321");
		customer1.setEmail("leo@gmail.com");

		Customer customer2 = new Customer();
		customer2.setFirstName("Abel");
		customer2.setLastName("Leo");
		customer2.setBvn("12345678432");
		customer2.setNin("987654019");
		customer2.setEmail("Ab@gmail.com");

		customer1 = customerRepository.save(customer1);
		customer2 = customerRepository.save(customer2);

		Account account1 = new Account();
		account1.setAccountNumber("1234567890");
		account1.setBalance(new BigDecimal("1000.00"));
		account1.setCustomer(customer1);

		Account account2 = new Account();
		//123456789
		account2.setAccountNumber("123456789");
		account2.setBalance(new BigDecimal("2000.00"));
		account2.setCustomer(customer2);

		accountRepository.save(account1);
		accountRepository.save(account2);

		// Preload Bank data
		Bank bank1 = new Bank();
		bank1.setName("Bank A");
		bankRepository.save(bank1);

		// Preload Bill Category, Biller, and Product data
		BillCategory category1 = new BillCategory();
		category1.setName("Utilities");
		category1 = billCategoryRepository.save(category1);

		Biller biller1 = new Biller();
		biller1.setName("Electricity Company");
		biller1.setCategory(category1);
		biller1 = billerRepository.save(biller1);

		Product product1 = new Product();
		product1.setName("Electricity Bill");
		product1.setPrice(new BigDecimal("100.00"));
		product1.setBiller(biller1);
		productRepository.save(product1);

		//userDetailsService.registerUser("admin", "password");

	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
}
