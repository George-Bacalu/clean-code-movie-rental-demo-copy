package com.endava.challenge.service;

import com.endava.challenge.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.endava.challenge.constants.Constants.CUSTOMER_NOT_FOUND_TEST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    private CustomerServiceImpl customerService;

    @Test
    void getTotalAmount_withValidCustomerName_shouldReturnTotalAmountCustomerRentals() {
        Double result = customerService.getTotalAmount("test_customer1").orElse(0.0);
        assertThat(result).isEqualTo(14.0);
    }

    @Test
    void getTotalAmount_withInvalidCustomerName_shouldReturnTotalAmountCustomerRentals() {
        assertThatThrownBy(() -> customerService.getTotalAmount("test_customer999"))
              .isInstanceOf(ResourceNotFoundException.class)
              .hasMessage(CUSTOMER_NOT_FOUND_TEST);
    }
}
