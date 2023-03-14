package com.endava.challenge.repository;

import com.endava.challenge.model.Customer;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.endava.challenge.mocks.CustomerMock.getMockedCustomer1;
import static com.endava.challenge.mocks.CustomerMock.getMockedCustomer2;
import static com.endava.challenge.mocks.CustomerMock.getMockedCustomer3;
import static com.endava.challenge.mocks.CustomerMock.getMockedCustomers;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CustomerRepositoryImplTest {

    @Autowired
    private CustomerRepositoryImpl customerRepository;

    private Customer customerMock1;
    private Customer customerMock2;
    private List<Customer> customersMock;

    @BeforeEach
    void setUp() {
        customerMock1 = getMockedCustomer1();
        customerMock2 = getMockedCustomer2();
        customersMock = getMockedCustomers();
    }

    @Test
    void findAll_shouldReturnAllCustomers() {
        assertThat(customerRepository.findAll()).isEqualTo(customersMock);
    }

    @Test
    void findByName_shouldReturnCustomerWithGivenName() {
        assertThat(customerRepository.findByName("test_customer1")).isEqualTo(Optional.of(customerMock1));
    }

    @Test
    void save_shouldAddCustomerToList() {
        Customer newCustomer = getMockedCustomer3();
        customerRepository.save(newCustomer);
        assertThat(customerRepository.findAll()).isEqualTo(List.of(customerMock1, customerMock2, newCustomer));
    }

    @Test
    void update_shouldModifyCustomerWithGivenName() {
        Customer updatedCustomer = getMockedCustomer3();
        assertThat(customerRepository.update(updatedCustomer, "test_customer1")).isEqualTo(updatedCustomer);
        assertThat(customerRepository.findAll()).isEqualTo(List.of(updatedCustomer, customerMock2));
    }

    @Test
    void delete_shouldDeleteCustomerFromList() {
        customerRepository.delete(customerMock1);
        assertThat(customerRepository.findAll()).isEqualTo(List.of(customerMock2));
    }
}
