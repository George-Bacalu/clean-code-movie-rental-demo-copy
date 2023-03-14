package com.endava.challenge.mocks;

import com.endava.challenge.model.Movie;
import com.endava.challenge.model.PriceCode;
import java.util.List;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class MovieMock {

    public static List<Movie> getMockedMovies() {
        return List.of(getMockedMovieRegular1(), getMockedMovieNewRelease1(), getMockedMovieChildren1());
    }

    public static Movie getMockedMovieRegular1() {
        return Movie.builder().title("test_movie1").priceCode(PriceCode.REGULAR).build();
    }

    public static Movie getMockedMovieNewRelease1() {
        return Movie.builder().title("test_movie2").priceCode(PriceCode.NEW_RELEASE).build();
    }

    public static Movie getMockedMovieChildren1() {
        return Movie.builder().title("test_movie3").priceCode(PriceCode.CHILDREN).build();
    }

    public static Movie getMockedMovieRegular2() {
        return Movie.builder().title("test_movie4").priceCode(PriceCode.REGULAR).build();
    }

    public static Movie getMockedMovieNewRelease2() {
        return Movie.builder().title("test_movie5").priceCode(PriceCode.NEW_RELEASE).build();
    }

    public static Movie getMockedMovieChildren2() {
        return Movie.builder().title("test_movie6").priceCode(PriceCode.CHILDREN).build();
    }

    public static Movie getMockedMovieRegular3() {
        return Movie.builder().title("test_movie7").priceCode(PriceCode.REGULAR).build();
    }

    public static Movie getMockedMovieNewRelease3() {
        return Movie.builder().title("test_movie8").priceCode(PriceCode.NEW_RELEASE).build();
    }

    public static Movie getMockedMovieChildren3() {
        return Movie.builder().title("test_movie9").priceCode(PriceCode.CHILDREN).build();
    }
}
