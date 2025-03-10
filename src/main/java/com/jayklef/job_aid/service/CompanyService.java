package com.jayklef.job_aid.service;

import com.jayklef.job_aid.model.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    boolean updateCompany(Company company, Long id);
}
