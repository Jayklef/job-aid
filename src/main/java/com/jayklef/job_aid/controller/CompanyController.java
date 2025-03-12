package com.jayklef.job_aid.controller;

import com.jayklef.job_aid.model.Company;
import com.jayklef.job_aid.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("{id}")
    public ResponseEntity<String> updateCompany(@PathVariable("id") Long id,
                                                @RequestBody Company company){
        boolean updated = companyService.updateCompany(company, id);
        if (updated){
            return new ResponseEntity<>("Company updated successfully", HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
