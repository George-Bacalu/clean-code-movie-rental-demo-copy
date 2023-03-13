package com.endava.challenge;

import java.util.List;

import static com.endava.challenge.Movie.CHILDREN;
import static com.endava.challenge.Movie.NEW_RELEASE;
import static com.endava.challenge.Movie.REGULAR;

public class MovieRentalExample {
    public static void main(String[] args) {
        Customer customer = new Customer("Customer1", List.of(
                new Rental(new Movie("Movie0", REGULAR), 2),
                new Rental(new Movie("Movie1", NEW_RELEASE), 2),
                new Rental(new Movie("Movie2", CHILDREN), 3))
        );
        System.out.println(customer.statement());
    }
}
