package com.jayklef.job_aid.controller;

import com.jayklef.job_aid.model.Company;
import com.jayklef.job_aid.service.CompanyService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> companies(){
        return companyService.getAllCompanies();
    }

}
