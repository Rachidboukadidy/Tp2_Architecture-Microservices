package com.rachid.Review_Service.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {
    private long ReviewId;
    private String Author;
    private String Subject;
    private String Content;
}
