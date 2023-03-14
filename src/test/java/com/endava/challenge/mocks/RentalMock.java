package com.endava.challenge.mocks;

import com.endava.challenge.model.Rental;
import java.util.List;
import lombok.NoArgsConstructor;

import static com.endava.challenge.mocks.MovieMock.getMockedMovieChildren1;
import static com.endava.challenge.mocks.MovieMock.getMockedMovieChildren2;
import static com.endava.challenge.mocks.MovieMock.getMockedMovieChildren3;
import static com.endava.challenge.mocks.MovieMock.getMockedMovieNewRelease1;
import static com.endava.challenge.mocks.MovieMock.getMockedMovieNewRelease2;
import static com.endava.challenge.mocks.MovieMock.getMockedMovieNewRelease3;
import static com.endava.challenge.mocks.MovieMock.getMockedMovieRegular1;
import static com.endava.challenge.mocks.MovieMock.getMockedMovieRegular2;
import static com.endava.challenge.mocks.MovieMock.getMockedMovieRegular3;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class RentalMock {

    public static List<Rental> getMockedRentals1() {
        return List.of(getMockedRentalMovieRegular1(), getMockedRentalMovieNewRelease1(), getMockedRentalMovieChildren1());
    }

    public static List<Rental> getMockedRentals2() {
        return List.of(getMockedRentalMovieRegular2(), getMockedRentalMovieNewRelease2(), getMockedRentalMovieChildren2());
    }

    public static List<Rental> getMockedRentals3() {
        return List.of(getMockedRentalMovieRegular3(), getMockedRentalMovieNewRelease3(), getMockedRentalMovieChildren3());
    }

    public static Rental getMockedRentalMovieRegular1() {
        return Rental.builder().movie(getMockedMovieRegular1()).daysRented(2).build();
    }

    public static Rental getMockedRentalMovieNewRelease1() {
        return Rental.builder().movie(getMockedMovieNewRelease1()).daysRented(3).build();
    }

    public static Rental getMockedRentalMovieChildren1() {
        return Rental.builder().movie(getMockedMovieChildren1()).daysRented(4).build();
    }

    public static Rental getMockedRentalMovieRegular2() {
        return Rental.builder().movie(getMockedMovieRegular2()).daysRented(3).build();
    }

    public static Rental getMockedRentalMovieNewRelease2() {
        return Rental.builder().movie(getMockedMovieNewRelease2()).daysRented(2).build();
    }

    public static Rental getMockedRentalMovieChildren2() {
        return Rental.builder().movie(getMockedMovieChildren2()).daysRented(5).build();
    }

    public static Rental getMockedRentalMovieRegular3() {
        return Rental.builder().movie(getMockedMovieRegular3()).daysRented(3).build();
    }

    public static Rental getMockedRentalMovieNewRelease3() {
        return Rental.builder().movie(getMockedMovieNewRelease3()).daysRented(4).build();
    }

    public static Rental getMockedRentalMovieChildren3() {
        return Rental.builder().movie(getMockedMovieChildren3()).daysRented(2).build();
    }
}
