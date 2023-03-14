package com.endava.challenge.repository;

import com.endava.challenge.model.Rental;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.endava.challenge.mocks.RentalMock.getMockedRentals1;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RentalRepositoryImplTest {

    @Autowired
    private RentalRepositoryImpl rentalRepository;

    private List<Rental> rentalsMock;

    @BeforeEach
    void setUp() {
        rentalsMock = getMockedRentals1();
    }

    @Test
    void findAll_shouldReturnAllRentals() {
        assertThat(rentalRepository.findAll()).isEqualTo(rentalsMock);
    }
}
