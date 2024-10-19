package com.rachid.Product_Service.Entity;

import com.rachid.Product_Service.Feign.microservice.RecommendationResponse;
import com.rachid.Product_Service.Feign.microservice.ReviewResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="Product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private double weight;

}
