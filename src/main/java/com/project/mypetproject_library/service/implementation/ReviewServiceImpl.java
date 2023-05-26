package com.project.mypetproject_library.service.implementation;

import com.project.mypetproject_library.exception.NotFoundException;
import com.project.mypetproject_library.models.Review;
import com.project.mypetproject_library.repository.ReviewRepository;
import com.project.mypetproject_library.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.project.mypetproject_library.exception.NullEntityReferenceException;
import com.project.mypetproject_library.models.Role;
import com.project.mypetproject_library.repository.RoleRepository;
import com.project.mypetproject_library.service.RoleService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final Logger logger = LoggerFactory.getLogger(ReviewServiceImpl.class);

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review createReview(Review review) {
        logger.info("Creating new review with id {}", review.getId());
        return reviewRepository.save(review);
    }

    @Override
    public Review getReview(Long id) {
        logger.info("Getting review with id {}", id);
        return reviewRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Review with id " + id + " was not found"));
    }

    @Override
    public List<Review> getAllReviews() {
        logger.info("Getting all reviews");
        return reviewRepository.findAll();
    }

    @Override
    public Review updateReview(Long id, Review review) {
        logger.info("Updating review with id {}", id);
        return reviewRepository.findById(id)
                .map(existingReview -> {
                    BeanUtils.copyProperties(review, existingReview, "id");
                    return reviewRepository.save(existingReview);
                })
                .orElseThrow(() -> new NotFoundException("Review with id " + id + " was not found"));
    }

    @Override
    public void deleteReview(Long id) {
        logger.info("Deleting review with id {}", id);
        reviewRepository.deleteById(id);
    }
}
