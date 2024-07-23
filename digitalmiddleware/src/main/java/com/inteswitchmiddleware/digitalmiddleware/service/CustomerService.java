package com.inteswitchmiddleware.digitalmiddleware.service;

import com.inteswitchmiddleware.digitalmiddleware.dto.request.CustomerRequest;
import com.inteswitchmiddleware.digitalmiddleware.dto.response.CustomerResponse;
import com.inteswitchmiddleware.digitalmiddleware.entity.Account;
import com.inteswitchmiddleware.digitalmiddleware.entity.Customer;
import com.inteswitchmiddleware.digitalmiddleware.repository.AccountRepository;
import com.inteswitchmiddleware.digitalmiddleware.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    private AccountRepository accountRepository;


    public boolean validateBvn(String bvn){
        //csll dojah/NIBBS for NIN validation here!
        return true;
    }

    public boolean validateNin(String nin) {
    //csll dojah/NIBBS for NIN validation here!
        return true;
    }

    public Customer onboardCustomer(CustomerRequest customerRequest) {

        //save customer to the db after creating an account for him
        // Here you can add additional validation for BVN and NIN if needed

        Customer custerEntity = new Customer();
        //use modelmapper for faster mapping!
        custerEntity.setEmail(customerRequest.getEmail());
        custerEntity.setBvn(customerRequest.getBvn());
        custerEntity.setNin(customerRequest.getNin());
        custerEntity.setLastName(customerRequest.getLastName());
        custerEntity.setFirstName(customerRequest.getFirstName());
        //custerEntity.setAccounts(customerRequest.getAccounts());

        Customer savedCustomer = customerRepository.save(custerEntity);

        // Create an account for the new customer
        Account account = new Account();
        account.setAccountNumber(generateAccountNumber());
        account.setBalance(BigDecimal.ZERO);
        account.setCustomer(savedCustomer);

        accountRepository.save(account);

        return savedCustomer;
    }

    private String generateAccountNumber() {
        //generate random acc number here

         final int ACCOUNT_NUMBER_LENGTH = 12;
         Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();

        for (int i = 0; i < ACCOUNT_NUMBER_LENGTH; i++) {
            int digit = random.nextInt(10);
            accountNumber.append(digit);
        }

        return accountNumber.toString();

        //return "";

    }

    public CustomerResponse getCustomerById(Long customerId) {

        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        Customer returnedCustomer =  optionalCustomer.get();

       CustomerResponse customerResponse = CustomerResponse.builder()
        .email(returnedCustomer.getEmail())
        .nin(returnedCustomer.getNin())
        .bvn(returnedCustomer.getBvn())
        .firstName(returnedCustomer.getFirstName())
        .lastName(returnedCustomer.getLastName())
        //.accounts(returnedCustomer.getAccounts())
        .build();

   return customerResponse;

    }

    public List<CustomerResponse> getAllCustomers(int page, int limit) {

        List<CustomerResponse> returnValue = new ArrayList<>();

        if(page>0) page = page-1;

        Pageable pageableRequest = PageRequest.of(page,limit);

        Page<Customer> customerPage = customerRepository.findAll(pageableRequest);

        List<Customer> returnedCustomers = customerPage.getContent();

        CustomerResponse customerResponse;

        for (Customer customer: returnedCustomers){
            customerResponse = CustomerResponse.builder()
            .email(customer.getEmail())
            .nin(customer.getNin())
            .firstName(customer.getFirstName())
            .lastName(customer.getLastName())
            .build();

            returnValue.add(customerResponse);
        }

        return returnValue;

    }
}

