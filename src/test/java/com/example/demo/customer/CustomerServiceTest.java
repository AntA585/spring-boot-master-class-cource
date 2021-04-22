package com.example.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {

    private CustomerService underTest;
    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {

        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        //given
        Customer Anthony = new Customer(1L,"Anthony","hello","Anthony@house.com");
        Customer Harper = new Customer(2L,"Harper","hello2","Harper@house.com");

        customerRepository.saveAll(Arrays.asList(Anthony,Harper));

        //when
        List<Customer> customers = underTest.getCustomers();

        //then
        assertEquals(2,customers.size());
    }

    @Test
    void getCustomer() {
        //given
        Customer Harper = new Customer(1L,"Harper","hello2","Harper@house.com");

        customerRepository.saveAll(Arrays.asList(Harper));
        //when
        Customer actual = underTest.getCustomer(1L);

        //then
        assertEquals(1L,actual.getId());
        assertEquals("Harper",actual.getName());
        assertEquals("hello2    ",actual.getPassword());
        assertEquals("Harper@house.com",actual.getEmail());

    }
}