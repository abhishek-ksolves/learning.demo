package com.learning.demo.controller;

import com.learning.demo.entities.Customer;
import com.learning.demo.model.CustomerLoginDetail;
import com.learning.demo.service.CustomerCrudOperationService;
import com.learning.demo.service.CustomerLoginService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CustomerController {
    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    Logger sl4logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerLoginService custLoginService;
    @Autowired
    private CustomerCrudOperationService customerService;


//    @CrossOrigin(origins = "http://172.16.10.26:8081")
    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        sl4logger.info("Get info from get customers");
        return customerService.getCustomers();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable("id") int id){
        return custLoginService.getCustomer(id);
    }

    @GetMapping("/customers/page")
    public List<Customer> getAllCustomer(@RequestParam("page") int page) {
        return custLoginService.getPaginatedCustomer(page);
    }

    @GetMapping("/customers/page/descending")
    public List<Customer> getAllCustomerSorted(@RequestParam("page") int page) {
        return custLoginService.getPaginatedCustomerSorted(page);
    }

//    @CrossOrigin(origins = "http://172.16.10.26:8081")
    @PostMapping("/customer")
    public Customer addCustomer(@RequestBody @Valid CustomerLoginDetail customer) throws InterruptedException{
        logger.info("Added customer");
        return custLoginService.addCustomer(customer);
    }

    @PostMapping(value = "/customer/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerLoginDetail> saveCustomer(@RequestBody @Valid CustomerLoginDetail customer){
        return new ResponseEntity<>(custLoginService.addCustomerNew(customer), HttpStatus.OK);
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable("id") int id){
        customerService.deleteCustomer(id);
    }

    @PutMapping("/customer")
    public Customer updateCustomer(@RequestBody CustomerLoginDetail customer){
        return customerService.update(customer);
    }
//    @PostMapping("/login")
//    public void login(){
//
//    }

//    @GetMapping("/getCustomer")
//    public Customer getCustomer(@RequestParam Integer Id){
//        return custLoginService.getCustomer(Id);
//    }

//    @PostMapping("/addCustomer")
//    public void addCustomer1(@RequestBody Customer customer){
//        custLoginService.addCustomer(customer);
//    }

//    @PostMapping("/addCustomer")
//    public void addCustomer(@RequestBody CustomerLoginDetail customer){
//        custLoginService.addCustomer3(customer);
//    }
}
