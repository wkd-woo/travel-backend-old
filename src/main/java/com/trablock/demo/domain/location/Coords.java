package com.trablock.demo.domain.location;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
@AllArgsConstructor
public class Coords {

    //private Location location;
    private double latitude;
    private double longitude;

    protected Coords() {
    }

}
