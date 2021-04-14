package com.example.demo.customer;


import com.example.demo.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        LOGGER.info("getCustomers was called to retrieve all");
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(
                        () -> {NotFoundException notFoundException = new NotFoundException("Customer with id " + id + " not found");
                        LOGGER.error("Error in getting customer with id",id,notFoundException);
        return  notFoundException;
                        });
    }
}
