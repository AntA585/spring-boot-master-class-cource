package com.example.demo.customer;

import com.example.demo.infoapp.InfoApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class CustomerConfiguration {

    @Value("${app.useFakeCustomerRepository:false}")
    private Boolean useFakeCustomerRepository;

    @Value("${info.app.name}")
    private String appName;

    @Autowired
    private Environment environment;

    @Bean
    CommandLineRunner commandLineRunner(InfoApp infoApp){
        return args -> {
            System.out.println("Command Line Runner horray");
            System.out.println(appName);
            System.out.println(environment.getProperty("info.app.description"));
            System.out.println(infoApp);
        };
    }

    @Bean
    CustomerRepo customerRepo(){
        System.out.println("useFakeCustomerRepository "+ useFakeCustomerRepository);
        return new CustomerFakeRepository();
    }
}
