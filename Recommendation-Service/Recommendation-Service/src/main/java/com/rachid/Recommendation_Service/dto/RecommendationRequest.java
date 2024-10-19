package com.rachid.Recommendation_Service.dto;

import com.rachid.Recommendation_Service.entity.Recommendation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RecommendationRequest {
    private long RecommendationId;
    private String author;
    private int  rate ;
    private String content ;

}
