package com.rachid.Product_Service.Feign.microservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecommendationResponse {
    private long recommendationId;
    private String author;
    private int  rate ;
    private String content ;

}
