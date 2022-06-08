package com.trablock.demo.domain.plan;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class TravelPlan {

    @Id @GeneratedValue
    @Column(name = "travel_plan_id")
    private Long id;

    private String name;
    private String destination;
    private int periods;
    private String depart;

    @Embedded
    private TravelDays travelDays;
    //private SelectedLocation selectedLocation -추후 SelectedLocation 클래스가 완성되면 사용 예정입니다.


    protected TravelPlan() { }
}
