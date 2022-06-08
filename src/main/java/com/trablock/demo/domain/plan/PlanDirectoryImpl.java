package com.trablock.demo.domain.plan;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class PlanDirectoryImpl implements PlanDirectory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "travel_plan_id")
    private Long id;

    private Long canvasId;
    private String name;
}
