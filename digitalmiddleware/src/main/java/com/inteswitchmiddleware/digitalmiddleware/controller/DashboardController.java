package com.inteswitchmiddleware.digitalmiddleware.controller;

import com.inteswitchmiddleware.digitalmiddleware.dto.response.CustomerResponse;
import com.inteswitchmiddleware.digitalmiddleware.entity.Customer;
import com.inteswitchmiddleware.digitalmiddleware.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/dashboard")
@AllArgsConstructor
public class DashboardController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getCustAll(@RequestParam(value="page",defaultValue = "0") int page,
                                                            @RequestParam(value = "limit",defaultValue = "2") int limit){

        List<CustomerResponse> customers = customerService.getAllCustomers(page,limit);

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    //move this to customer controller class!!!
    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerDashboard(@PathVariable Long customerId){

       CustomerResponse customerResponse = customerService.getCustomerById(customerId);

        return null;
    }

}
