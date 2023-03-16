package com.endava.challenge.service;

import com.endava.challenge.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.endava.challenge.constants.Constants.CUSTOMER_NOT_FOUND_TEST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class RentalServiceImplTest {

    @Autowired
    private RentalServiceImpl rentalService;

    @Test
    void getRentalInfoTextVersion_withValidCustomer_shouldReturnCustomerRentalsInfoAsText() {
        String result = rentalService.getRentalInfoTextVersion("test_customer1");
        String text = """
              Rental Record for test_customer1:
              test_movie1: 2.0
              test_movie2: 9.0
              test_movie3: 3.0
              Amount owned: 14.0
              You earned 4 frequent renter points""";
        assertThat(result).isEqualTo(text);
    }

    @Test
    void getRentalInfoTextVersion_withInvalidCustomer_shouldThrowException() {
        assertThatThrownBy(() -> rentalService.getRentalInfoTextVersion("test_customer999"))
              .isInstanceOf(ResourceNotFoundException.class)
              .hasMessage(CUSTOMER_NOT_FOUND_TEST);
    }

    @Test
    void getRentalInfoHtmlVersion_withValidCustomer_shouldReturnCustomerRentalsInfoAsHtml() {
        String result = rentalService.getRentalInfoHtmlVersion("test_customer1");
        String text = """
              <!DOCTYPE html>
              <html lang="en">
                <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <meta http-equiv="X-UA-Compatible" content="ie=edge">
                  <title>Movie Rental</title>
                </head>
                <body>
                  <ul>
                    <li>test_movie1: 2.0</li>
                    <li>test_movie2: 9.0</li>
                    <li>test_movie3: 3.0</li>
                  </ul>
                  <h3>Amount owned: 14.0</h3>
                  <h3>You earned 4 frequent renter points</h3>
                </body>
              </html>""";
        System.out.println(result);
        assertThat(result).isEqualTo(text);
    }

    @Test
    void getRentalInfoHtmlVersion_withInvalidCustomer_shouldThrowException() {
        assertThatThrownBy(() -> rentalService.getRentalInfoTextVersion("test_customer999"))
              .isInstanceOf(ResourceNotFoundException.class)
              .hasMessage(CUSTOMER_NOT_FOUND_TEST);
    }
}
