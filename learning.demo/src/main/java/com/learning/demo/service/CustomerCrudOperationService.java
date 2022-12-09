package com.learning.demo.service;

import com.learning.demo.entities.Customer;
import com.learning.demo.model.CustomerLoginDetail;
import com.learning.demo.repository.CustomerLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerCrudOperationService {
    @Autowired
    private CustomerLoginRepository customerLoginRepository;

    public List<Customer> getCustomers(){
        return customerLoginRepository.findAll();
    }

    public void deleteCustomer(int id) {
        customerLoginRepository.deleteById(id);
    }

    public Customer update(CustomerLoginDetail customer) {
        Customer c = new Customer(customer.getId(), customer.getName(), customer.getEmail(), customer.getAge(), customer.getPassword());
        return customerLoginRepository.save(c);
    }


}
