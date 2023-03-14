package com.endava.challenge.mocks;

import com.endava.challenge.model.Customer;
import java.util.List;
import lombok.NoArgsConstructor;

import static com.endava.challenge.mocks.RentalMock.getMockedRentals1;
import static com.endava.challenge.mocks.RentalMock.getMockedRentals2;
import static com.endava.challenge.mocks.RentalMock.getMockedRentals3;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CustomerMock {

    public static List<Customer> getMockedCustomers() {
        return List.of(getMockedCustomer1(), getMockedCustomer2());
    }

    public static Customer getMockedCustomer1() {
        return Customer.builder().name("test_customer1").rentals(getMockedRentals1()).build();
    }

    public static Customer getMockedCustomer2() {
        return Customer.builder().name("test_customer2").rentals(getMockedRentals2()).build();
    }

    public static Customer getMockedCustomer3() {
        return Customer.builder().name("test_customer3").rentals(getMockedRentals3()).build();
    }
}
