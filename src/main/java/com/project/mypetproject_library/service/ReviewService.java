package com.project.mypetproject_library.service;

import com.project.mypetproject_library.models.Review;

import java.util.List;

public interface ReviewService {
    Review createReview(Review review);

    Review getReview(Long id);

    List<Review> getAllReviews();

    Review updateReview(Long id, Review review);

    void deleteReview(Long id);
}
