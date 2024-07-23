package com.inteswitchmiddleware.digitalmiddleware.controller;

import com.inteswitchmiddleware.digitalmiddleware.dto.request.CustomerRequest;
import com.inteswitchmiddleware.digitalmiddleware.dto.response.CustomerResponse;
import com.inteswitchmiddleware.digitalmiddleware.entity.Customer;
import com.inteswitchmiddleware.digitalmiddleware.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")//onboard
@AllArgsConstructor
public class CustomerController {

   // @Autowired
    private final CustomerService customerService;

//    @GetMapping
//    public String getAllCustomers(){
//
//        return "all customers!!!";
//    }

    @PostMapping("/onboard")
    public ResponseEntity<CustomerResponse> onboardCustomer(@Valid @RequestBody CustomerRequest customer) {
        if (!customerService.validateBvn(customer.getBvn())) {
            return ResponseEntity.badRequest().body(null); // BVN validation failed
        }
        if (!customerService.validateNin(customer.getNin())) {
            return ResponseEntity.badRequest().body(null); // NIN validation failed
        }
        Customer createdCustomer = customerService.onboardCustomer(customer);

        CustomerResponse customerResponse = CustomerResponse.builder()
        .nin(createdCustomer.getNin())
        .bvn(createdCustomer.getBvn())
        .firstName(createdCustomer.getFirstName())
        .lastName(createdCustomer.getLastName())
        //.accounts(createdCustomer.getAccounts())
        .build();

        return new ResponseEntity<>(customerResponse, HttpStatusCode.valueOf(201)); //.created().body(customerResponse); //.ok(customerResponse);
    }

//    @Autowired
//    PersonRepository personRepository;
//
//    @RequestMapping("/dashboard")
//    public String displayDashboard(Model model,Authentication authentication, HttpSession session) {
//        Person person = personRepository.readByEmail(authentication.getName());
//        model.addAttribute("username", person.getName());
//        model.addAttribute("roles", authentication.getAuthorities().toString());
//        session.setAttribute("loggedInPerson", person);
//        return "dashboard.html";
//    }


//    Step 5: Implement Customer Onboarding
//    Create a new service for Customer Onboarding.
//    Define entities for Customer, BVN, and NIN.
//    Create a repository interface for Customer.
//    Implement a service class to handle onboarding logic.
//    Create a REST controller to expose the onboarding endpoint.
//    Add validation for BVN and NIN inputs.
}
