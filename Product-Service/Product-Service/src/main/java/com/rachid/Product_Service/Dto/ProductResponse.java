package com.rachid.Product_Service.Dto;

import com.rachid.Product_Service.Entity.Product;
import com.rachid.Product_Service.Feign.microservice.RecommendationResponse;
import com.rachid.Product_Service.Feign.microservice.ReviewResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private long id;
    private String name;
    private double weight;

    private RecommendationResponse recommendationRes;
    private ReviewResponse reviewRes;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.weight = product.getWeight();
    }
}
