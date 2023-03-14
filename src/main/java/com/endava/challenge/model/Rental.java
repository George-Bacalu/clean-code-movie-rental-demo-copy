package com.endava.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Rental {
    private Movie movie;
    private int daysRented;
}
