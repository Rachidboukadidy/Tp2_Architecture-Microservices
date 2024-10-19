package com.rachid.Product_Service.Feign;

import com.rachid.Product_Service.Feign.microservice.ReviewResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name = "Review-Service")
public interface ReviewClient {
    @GetMapping("reviews/{id}")
    ReviewResponse getReviewsByProductId(@PathVariable Long id);
}
