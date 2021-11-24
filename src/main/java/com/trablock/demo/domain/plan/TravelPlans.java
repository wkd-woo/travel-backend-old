package com.trablock.demo.domain.plan;

import lombok.AllArgsConstructor;

import javax.persistence.*;

@Embeddable
@AllArgsConstructor
@Entity
public class TravelPlans {

    @Id @GeneratedValue
    @Column(name = "plan_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "travel_plan_id")
    private TravelPlan travelPlan;

    protected TravelPlans() { }
}
