package com.jayklef.job_aid.controller;

import com.jayklef.job_aid.model.Review;
import com.jayklef.job_aid.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private ReviewService reviewService;


    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable("companyId") Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }
    @PostMapping("/reviews/save")
    public ResponseEntity<String> saveReview(@PathVariable("companyId") Long companyId,
                                             @RequestBody Review review){
        boolean isReviewSaved = reviewService.saveReview(companyId, review);
        if (isReviewSaved)
        return new ResponseEntity<>("review added successfully", HttpStatus.CREATED);
        else
            return new ResponseEntity<>("review not saved", HttpStatus.NOT_FOUND);
    }
}
