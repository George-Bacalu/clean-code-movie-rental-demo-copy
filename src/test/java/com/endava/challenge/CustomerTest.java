package com.endava.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    public static final String MOVIE_REGULAR = "test_movie_regular";
    public static final String CUSTOMER_NAME = "test_customer_name";
    public static final int RENTED_DAYS = 3;

    private final Movie movie = new Movie(MOVIE_REGULAR, Movie.REGULAR);
    private final Rental rental = new Rental(movie, RENTED_DAYS);
    private final Customer customer = new Customer(CUSTOMER_NAME);

    @BeforeEach
    void setUp() {
        customer.getRentals().add(rental);
    }

    @Test
    void test_statement() {
        String result = "Rental Record for " + CUSTOMER_NAME + "\n\t" + MOVIE_REGULAR + "\t3.5\n" + "Amount owed is 3.5\n" + "You earned 1 frequent renter points";
        assertEquals(result, customer.statement());
    }
}
