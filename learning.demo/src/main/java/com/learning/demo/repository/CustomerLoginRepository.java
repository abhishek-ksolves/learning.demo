package com.learning.demo.repository;

import com.learning.demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerLoginRepository extends JpaRepository<Customer, Integer> {
}
