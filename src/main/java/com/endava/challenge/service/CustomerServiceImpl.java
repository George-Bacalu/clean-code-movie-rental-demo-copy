package com.endava.challenge.service;

import com.endava.challenge.exception.ResourceNotFoundException;
import com.endava.challenge.model.Customer;
import com.endava.challenge.model.Rental;
import com.endava.challenge.repository.CustomerRepository;
import com.endava.challenge.service.price.ChildrenMoviePriceCalculator;
import com.endava.challenge.service.price.MoviePriceCalculator;
import com.endava.challenge.service.price.NewReleaseMoviePriceCalculator;
import com.endava.challenge.service.price.RegularMoviePriceCalculator;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.endava.challenge.constants.Constants.CUSTOMER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    @Override
    public Optional<Double> getTotalAmount(String customerName) {
        Optional<Customer> customer = customerRepository.findByName(customerName);
        if(customer.isEmpty()) {
            throw new ResourceNotFoundException(String.format(CUSTOMER_NOT_FOUND, customerName));
        }
        return Optional.of(customer.get().getRentals().stream().mapToDouble(rental -> getAmount(rental, 0.0)).reduce(0, Double::sum));
    }

    @Override
    public Double getAmount(Rental rental, Double amount) {
        MoviePriceCalculator moviePriceCalculator = switch (rental.getMovie().getPriceCode()) {
            case REGULAR -> new RegularMoviePriceCalculator();
            case NEW_RELEASE -> new NewReleaseMoviePriceCalculator();
            case CHILDREN -> new ChildrenMoviePriceCalculator();
        };
        return moviePriceCalculator.getAmount(rental, amount);
    }
}
