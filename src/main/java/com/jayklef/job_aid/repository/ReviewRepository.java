package com.jayklef.job_aid.repository;

import com.jayklef.job_aid.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
