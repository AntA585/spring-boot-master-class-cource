package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {

    @Value("${app.useFakeCustomerRepository:false}")
    private Boolean useFakeCustomerRepository;

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            System.out.println("Command Line Runner horray");
        };
    }

    @Bean
    CustomerRepo customerRepo(){
        System.out.println("useFakeCustomerRepository "+ useFakeCustomerRepository);
        return useFakeCustomerRepository ? new CustomerFakeRepository() : new CustomerRepository();
    }
}
