package com.rachid.Product_Service.Feign;

import com.rachid.Product_Service.Feign.microservice.RecommendationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name = "Recommendation-Service")
public interface RecommendationClient {
    @GetMapping("recommendation/{id}")
    RecommendationResponse getRecommendationByProductId(@PathVariable Long id);
}
