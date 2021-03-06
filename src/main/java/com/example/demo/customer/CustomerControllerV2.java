package com.example.demo.customer;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RequestMapping(path = "api/v2/customer")
@RestController
@AllArgsConstructor
public class CustomerControllerV2 {

    private final CustomerService customerService;


    @GetMapping(value = "all")
    List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping(path = "{customerId}")
    Customer getCustomer(@PathVariable("customerId") Long id) {
        return customerService.getCustomer(id);
    }

    @PostMapping
    void createNewCustomer(@RequestBody @Valid Customer customer) {
        System.out.println("POST REQUEST...");
        System.out.println(customer);

    }

    @DeleteMapping(path = "{customerId}")
    void deleteCustmomer(@PathVariable("customerId") Long id) {
        System.out.println("DELETE REQUEST OF CUSTOMER WITH ID " + id);
    }

    @PutMapping
    void updateCustomer(@RequestBody Customer customer) {
        System.out.println("UPDATE CUSTOMER ");
        System.out.println(customer);
    }

}
