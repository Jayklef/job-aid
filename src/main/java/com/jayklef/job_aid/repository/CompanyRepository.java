package com.jayklef.job_aid.repository;

import com.jayklef.job_aid.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
