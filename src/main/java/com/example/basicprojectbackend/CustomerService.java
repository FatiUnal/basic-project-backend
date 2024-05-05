package com.example.basicprojectbackend;

import org.apache.coyote.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomer(){
        return customerRepository.findAll();
    }

    public Customer createCustomer(CustomerDto customerDto){
        Customer customer = new Customer(customerDto.getName(),customerDto.getEmail());
        return customerRepository.save(customer);
    }

    public Customer updateCustpmer(CustomerDto customerDto,int id){
        Customer customer = customerRepository.findById(id).orElseThrow(RuntimeException::new);
        customer.setEmail(customerDto.getEmail());
        customer.setName(customerDto.getName());
        return customerRepository.save(customer);
    }

    public String deleteCustomer(int id){
        customerRepository.deleteById(id);
        return "Customer deleted";
    }
}

