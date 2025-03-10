package com.jayklef.job_aid.repository;

import com.jayklef.job_aid.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
