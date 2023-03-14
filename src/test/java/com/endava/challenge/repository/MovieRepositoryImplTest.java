package com.endava.challenge.repository;

import com.endava.challenge.model.Movie;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.endava.challenge.mocks.MovieMock.getMockedMovies;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MovieRepositoryImplTest {

    @Autowired
    private MovieRepositoryImpl movieRepository;

    private List<Movie> moviesMock;

    @BeforeEach
    void setUp() {
        moviesMock = getMockedMovies();
    }

    @Test
    void findAll_shouldReturnAllMovies() {
        assertThat(movieRepository.findAll()).isEqualTo(moviesMock);
    }
}
