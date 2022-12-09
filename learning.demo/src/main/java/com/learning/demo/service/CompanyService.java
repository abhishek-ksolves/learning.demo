package com.learning.demo.service;

import com.learning.demo.entities.Company;
import com.learning.demo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepo;

    public Company addCompany(Company company){
        companyRepo.save(company);
        return company;
    }
    public List<Company> getCompanies(){
        return companyRepo.findAll();
    }
}
