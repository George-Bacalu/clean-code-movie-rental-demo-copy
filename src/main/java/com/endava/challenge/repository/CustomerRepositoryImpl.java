package com.endava.challenge.repository;

import com.endava.challenge.model.Customer;
import com.endava.challenge.model.Movie;
import com.endava.challenge.model.PriceCode;
import com.endava.challenge.model.Rental;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private final List<Customer> customers = new ArrayList<>();

    @PostConstruct
    private void initializeCustomers() {
        customers.add(new Customer("test_customer1", List.of(
              new Rental(new Movie("test_movie1", PriceCode.REGULAR), 2),
              new Rental(new Movie("test_movie2", PriceCode.NEW_RELEASE), 3),
              new Rental(new Movie("test_movie3", PriceCode.CHILDREN), 4))));
        customers.add(new Customer("test_customer2", List.of(
              new Rental(new Movie("test_movie4", PriceCode.REGULAR), 3),
              new Rental(new Movie("test_movie5", PriceCode.NEW_RELEASE), 2),
              new Rental(new Movie("test_movie6", PriceCode.CHILDREN), 5))));
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Optional<Customer> findByName(String name) {
        return customers.stream().filter(customer -> name.equals(customer.getName())).findFirst();
    }

    @Override
    public void save(Customer customer) {
        customers.add(customer);
    }

    @Override
    public Customer update(Customer customer, String name) {
        Customer updatedCustomer = findByName(name).orElseThrow();
        updatedCustomer.setName(customer.getName());
        updatedCustomer.setRentals(customer.getRentals());
        return updatedCustomer;
    }

    @Override
    public void delete(Customer customer) {
        customers.remove(customer);
    }
}
