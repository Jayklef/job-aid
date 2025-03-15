package com.jayklef.job_aid.service;

import com.jayklef.job_aid.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean saveReview(Long companyId, Review review);
    Review getReview(Long companyId, Long reviewId);
}
