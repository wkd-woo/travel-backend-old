package com.trablock.demo.domain.plan;

import com.trablock.demo.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class TrashDirectory implements PlanDirectory{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trash_directory_id")
    private Long id;

    private String name;
    private int type;

    @Embedded
    private TravelPlans travelPlans;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
