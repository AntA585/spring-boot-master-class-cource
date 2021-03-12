package com.example.demo.customer;

import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(

                new Customer(1L,"James Bond", "123password"),
                new Customer(2L,"Anthony Allen", "password123")
        );
    }
}
