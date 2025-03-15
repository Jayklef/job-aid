package com.jayklef.job_aid.Impl;

import com.jayklef.job_aid.model.Company;
import com.jayklef.job_aid.model.Review;
import com.jayklef.job_aid.repository.ReviewRepository;
import com.jayklef.job_aid.service.CompanyService;
import com.jayklef.job_aid.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean saveReview(Long companyId, Review review) {
        Company company = companyService.getCompany(companyId);
        if (company != null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review review) {
        if (companyService.getCompany(companyId) != null){
            review.setCompany(companyService.getCompany(companyId));
            review.setId(reviewId);
            reviewRepository.save(review);
            return true;
        } else {
            return false;
        }
    }
}
