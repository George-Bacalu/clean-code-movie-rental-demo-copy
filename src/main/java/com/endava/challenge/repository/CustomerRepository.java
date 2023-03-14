package com.endava.challenge.repository;

import com.endava.challenge.model.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    List<Customer> findAll();

    Optional<Customer> findByName(String name);

    void save(Customer customer);

    Customer update(Customer customer, String name);

    void delete(Customer customer);
}
