package com.rentacarapp.rentacarsystem.service;

import com.rentacarapp.rentacarsystem.dto.FeedbackDTO;
import com.rentacarapp.rentacarsystem.entity.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface FeedbackService {
    FeedbackDTO createFeedback(FeedbackDTO feedbackDTO, UserDetails currentUser);
    Page<FeedbackDTO> getFeedbacksByBranch(Integer branchId, Pageable pageable);
    List<Feedback> getAllFeedbacks();

    // New method for dashboard stats
    long countFeedbackByBranch(Integer branchId);

    // Delete feedback method
    void deleteFeedback(Integer feedbackId, UserDetails currentUser);
}