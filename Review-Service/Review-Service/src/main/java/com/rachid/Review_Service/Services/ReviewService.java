package com.rachid.Review_Service.Services;

import com.rachid.Review_Service.Dto.ReviewRequest;
import com.rachid.Review_Service.Dto.ReviewResponse;
import com.rachid.Review_Service.entity.Review;

import java.util.List;

public interface ReviewService {
    public ReviewResponse addReview(ReviewRequest reviewRequest);
    public ReviewResponse getReview(long id);
    public List<ReviewResponse> getAllReviews();
    public void updateReview( long id,ReviewRequest reviewRequest);
    public void deleteReview(long id);
    public List<ReviewResponse> getReviewsByProduct(long id);
}
