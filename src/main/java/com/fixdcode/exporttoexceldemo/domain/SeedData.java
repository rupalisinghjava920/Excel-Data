package com.fixdcode.exporttoexceldemo.domain;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
public class SeedData {
    private CustomerRepository customerRepository;

    public SeedData(CustomerRepository customerRepository){

        this.customerRepository = customerRepository;
    }

    private List<Customer> customers = Arrays.asList(
            new Customer("Sun","Sah","sun@gmail.com",new Address("India","same states","same city","same address")),
            new Customer("Rahul","Singh","rahul@gmail.com",new Address("India","same states","same city","same address"))
    );
    @PostConstruct
    public void saveCustomers(){
            customerRepository.saveAll(customers);
    }
}
