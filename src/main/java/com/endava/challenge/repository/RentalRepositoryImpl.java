package com.endava.challenge.repository;

import com.endava.challenge.model.Movie;
import com.endava.challenge.model.PriceCode;
import com.endava.challenge.model.Rental;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class RentalRepositoryImpl implements RentalRepository {
    private final List<Rental> rentals = new ArrayList<>();

    @PostConstruct
    private void initializeRentals() {
        rentals.add(new Rental(new Movie("test_movie1", PriceCode.REGULAR), 2));
        rentals.add(new Rental(new Movie("test_movie2", PriceCode.NEW_RELEASE), 3));
        rentals.add(new Rental(new Movie("test_movie3", PriceCode.CHILDREN), 4));
    }

    @Override
    public List<Rental> findAll() {
        return rentals;
    }
}
