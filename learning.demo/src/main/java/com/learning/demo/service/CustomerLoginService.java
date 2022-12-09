package com.learning.demo.service;

import com.learning.demo.entities.Customer;
import com.learning.demo.model.CustomerLoginDetail;
import com.learning.demo.repository.CustomerLoginRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CustomerLoginService {

    @Autowired
    private CustomerLoginRepository customerLoginRepo;

//    public void addCustomer(Customer c){
//        customerLoginRepo.save(c);
//    }
    public void addCustomer3(CustomerLoginDetail c){
        Customer c1 = new Customer();
        c1.setId(null);
        c1.setName(c.getName());
        c1.setEmail(c.getEmail());
        c1.setAge(c.getAge());
        c1.setPassword(c.getPassword());
        customerLoginRepo.save(c1);
    }

    public Customer addCustomer(CustomerLoginDetail c) throws InterruptedException{
        Customer c1 = new Customer(null, c.getName(), c.getEmail(), c.getAge(), c.getPassword());
        log.info("add customer " + c.getName());
        Thread.sleep(10000);
        return customerLoginRepo.save(c1);
    }

    public CustomerLoginDetail addCustomerNew(CustomerLoginDetail c){
        Customer c1 = new Customer(null, c.getName(), c.getEmail(), c.getAge(), c.getPassword());
        c1 = customerLoginRepo.save(c1);
        CustomerLoginDetail c2 = new CustomerLoginDetail(c1.getId(), c1.getName(), c1.getEmail(), c1.getAge(), c1.getPassword());
        return c2;
    }

    public Customer getCustomer(Integer Id){
        return customerLoginRepo.findById(Id).orElse(new Customer());
    }

    public List<Customer> getPaginatedCustomer(Integer page){
        Pageable firstPageThreeCustomer = PageRequest.of(page, 3);
        Page<Customer> allCustomer = customerLoginRepo.findAll(firstPageThreeCustomer);
        return allCustomer.toList();
    }

    public List<Customer> getPaginatedCustomerSorted(Integer page){
        Pageable sortedByAgeDesc = PageRequest.of(page, 3, Sort.by("age").descending());
        Page<Customer> allCustomer = customerLoginRepo.findAll(sortedByAgeDesc);
        return allCustomer.toList();
    }
}
