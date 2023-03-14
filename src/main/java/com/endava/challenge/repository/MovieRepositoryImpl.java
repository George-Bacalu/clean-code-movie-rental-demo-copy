package com.endava.challenge.repository;

import com.endava.challenge.model.Movie;
import com.endava.challenge.model.PriceCode;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
    private final List<Movie> movies = new ArrayList<>();

    @PostConstruct
    private void initializeMovies() {
        movies.add(new Movie("test_movie1", PriceCode.REGULAR));
        movies.add(new Movie("test_movie2", PriceCode.NEW_RELEASE));
        movies.add(new Movie("test_movie3", PriceCode.CHILDREN));
    }

    @Override
    public List<Movie> findAll() {
        return movies;
    }
}
