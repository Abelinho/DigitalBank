package com.inteswitchmiddleware.digitalmiddleware.controller;

import com.inteswitchmiddleware.digitalmiddleware.dto.response.BillCategoryResponse;
import com.inteswitchmiddleware.digitalmiddleware.entity.BillCategory;
import com.inteswitchmiddleware.digitalmiddleware.entity.Biller;
import com.inteswitchmiddleware.digitalmiddleware.entity.Product;
import com.inteswitchmiddleware.digitalmiddleware.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bills")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @GetMapping("/categories")
    public ResponseEntity<List<BillCategoryResponse>> getAllBillCategories(@RequestParam(value = "page",defaultValue = "0") int page,
                                                                            @RequestParam(value = "limit", defaultValue = "2") int limit) {
        List<BillCategoryResponse> categories = billingService.getAllBillCategories(page,limit);

        return ResponseEntity.ok(categories);
    }

    //the following were commented out as they need some finishing touches and are not required

//    @GetMapping("/billers/{categoryId}")
//    public ResponseEntity<List<Biller>> getBillersByCategory(@PathVariable Long categoryId) {
//        List<Biller> billers = billingService.getBillersByCategory(categoryId);
//        return ResponseEntity.ok(billers);
//    }
//
//    @GetMapping("/products/{billerId}")
//    public ResponseEntity<List<Product>> getProductsByBiller(@PathVariable Long billerId) {
//        List<Product> products = billingService.getProductsByBiller(billerId);
//        return ResponseEntity.ok(products);
//    }

    @PostMapping("/pay")
    public ResponseEntity<Void> submitPayment(@RequestParam Long productId, @RequestParam BigDecimal amount) {
        billingService.submitPayment(productId, amount);
        return ResponseEntity.ok().build();
    }
}
