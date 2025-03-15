package com.jayklef.job_aid.service;

import com.jayklef.job_aid.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
}
