package com.endava.challenge.service;

import com.endava.challenge.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.endava.challenge.constants.Constants.CUSTOMER_NOT_FOUND_TEST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class RenterPointsCalculatorServiceImplTest {

    @Autowired
    private RenterPointsCalculatorServiceImpl renterPointsCalculatorService;

    @Test
    void getTotalFrequentRenterPoints_withValidCustomerName_shouldReturnCustomerFrequentRenterPoints() {
        Integer result = renterPointsCalculatorService.getTotalFrequentRenterPoints("test_customer1").orElse(0);
        assertThat(result).isEqualTo(4);
    }

    @Test
    void getTotalFrequentRenterPoints_withInvalidCustomerName_shouldReturnCustomerFrequentRenterPoints() {
        assertThatThrownBy(() -> renterPointsCalculatorService.getTotalFrequentRenterPoints("test_customer999"))
              .isInstanceOf(ResourceNotFoundException.class)
              .hasMessage(CUSTOMER_NOT_FOUND_TEST);
    }
}
