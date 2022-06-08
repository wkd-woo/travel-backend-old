package com.trablock.demo.domain.plan;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class TravelDay {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "travel_days_id")
    private Long id;


}
