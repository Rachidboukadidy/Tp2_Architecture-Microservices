package com.rachid.Recommendation_Service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Recommendation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long recommendationId;

    @Column
    private String author;
    @Column
    private int  rate ;
    @Column
    private String content ;



}
