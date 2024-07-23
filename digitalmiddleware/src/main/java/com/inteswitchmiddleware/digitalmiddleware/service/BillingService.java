package com.inteswitchmiddleware.digitalmiddleware.service;

import com.inteswitchmiddleware.digitalmiddleware.dto.response.BillCategoryResponse;
import com.inteswitchmiddleware.digitalmiddleware.entity.*;
import com.inteswitchmiddleware.digitalmiddleware.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BillingService {

    @Autowired
    private BillCategoryRepository billCategoryRepository;

    @Autowired
    private BillerRepository billerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private AccountRepository accountRepository;

    public List<BillCategoryResponse> getAllBillCategories(int page, int limit) {

        List<BillCategoryResponse> returnValue = new ArrayList<>();
        if (page>0) page = page - 1;

        Pageable pageableRequest = PageRequest.of(page,limit);

        Page<BillCategory> billCategoryPage = billCategoryRepository.findAll(pageableRequest);

        List<BillCategory> returnedBillCats = billCategoryPage.getContent();

        BillCategoryResponse billCategoryResponse;

        //build a response for each billcat
        for (BillCategory billCategory: returnedBillCats){
            billCategoryResponse = BillCategoryResponse.builder()
            .name(billCategory.getName())
            .build();

            returnValue.add(billCategoryResponse);
        }

        return returnValue;
    }

    public List<Biller> getBillersByCategory(Long categoryId) {
        return billerRepository.findByCategoryId(categoryId);
    }

    public List<Product> getProductsByBiller(Long billerId) {
        return productRepository.findByBillerId(billerId);
    }

    @Transactional
    public void submitPayment(Long productId, BigDecimal amount) {
        // Implement payment logic here

        // Validate product
        Product product = productRepository.findById(productId)
        .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        if (product.getPrice().compareTo(amount) != 0) {
            throw new IllegalArgumentException("Invalid payment amount");
        }

        // Assume we have customer id from the authenticated context
        //not fully implemented yet
        Long customerId = getAuthenticatedCustomerId(); // Placeholder method
        Account account = accountRepository.findByCustomerId(1L);

        if (account == null || account.getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        // Deduct the amount from the customer's account
        account.setBalance(account.getBalance().subtract(amount));
        accountRepository.save(account);

        // Log the payment
        Payment payment = new Payment();
        payment.setProductId(productId);
        payment.setAmount(amount);
        payment.setPaymentDate(LocalDateTime.now());
        payment.setCustomer(account.getCustomer());

        paymentRepository.save(payment);

        // Optionally, send notification to the customer
        sendPaymentNotification(account.getCustomer(), payment); // Placeholder method
    }

    private void sendPaymentNotification(Customer customer, Payment payment) {
    }

    private Long getAuthenticatedCustomerId() {

        return 0L;
    }

    //to do: use constructor injection across
    // board; preload tables with data in main
    // class; test the implemented methods;
    // write unit tests?
}
