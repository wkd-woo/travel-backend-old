package com.trablock.demo.domain.plan;

import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class TravelDays {

    private List<TravelDay> travelDays = new ArrayList<>();
}
