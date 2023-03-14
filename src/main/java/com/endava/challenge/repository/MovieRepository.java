package com.endava.challenge.repository;

import com.endava.challenge.model.Movie;
import java.util.List;

public interface MovieRepository {

    List<Movie> findAll();
}
