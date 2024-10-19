package com.rachid.Product_Service.Feign.microservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReviewResponse {
    private long ReviewId;
    private String Author;
    private String Subject;
    private String Content;

}
