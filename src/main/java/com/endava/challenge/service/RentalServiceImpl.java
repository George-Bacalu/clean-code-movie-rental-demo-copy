package com.endava.challenge.service;

import com.endava.challenge.exception.ResourceNotFoundException;
import com.endava.challenge.model.Customer;
import com.endava.challenge.model.Rental;
import com.endava.challenge.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.endava.challenge.constants.Constants.CUSTOMER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;
    private final RenterPointsCalculatorService renterPointsCalculatorService;

    @Override
    public String getRentalInfoTextVersion(String customerName) {
        Optional<Customer> customer = customerRepository.findByName(customerName);
        if (customer.isEmpty()) {
            throw new ResourceNotFoundException(String.format(CUSTOMER_NOT_FOUND, customerName));
        }
        StringBuilder result = new StringBuilder();
        result.append("Rental Record for ")
              .append(customer.get().getName())
              .append(":\n");
        customer.get().getRentals().forEach(rental ->
              result.append(rental.getMovie().getTitle())
                    .append(": ")
                    .append(customerService.getAmount(rental, 0.0))
                    .append("\n"));
        result.append("Amount owned: ")
              .append(customerService.getTotalAmount(customerName).orElse(0.0))
              .append("\nYou earned ")
              .append(renterPointsCalculatorService.getTotalFrequentRenterPoints(customerName).orElse(0))
              .append(" frequent renter points");
        return result.toString();
    }

    @Override
    public String getRentalInfoHtmlVersion(String customerName) {
        Optional<Customer> customer = customerRepository.findByName(customerName);
        if (customer.isEmpty()) {
            throw new ResourceNotFoundException(String.format(CUSTOMER_NOT_FOUND, customerName));
        }
        StringBuilder result = new StringBuilder();
        String baseLine = """
              <!DOCTYPE html>
              <html lang="en">
                <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <meta http-equiv="X-UA-Compatible" content="ie=edge">
                  <title>Movie Rental</title>
                </head>
                <body>
              """;
        List<Rental> rentals = customer.get().getRentals();
        result.append(baseLine).append("\t<ul>\n");
        rentals.forEach(rental ->
              result.append("\t  <li>")
                    .append(rental.getMovie().getTitle())
                    .append(": ")
                    .append(customerService.getAmount(rental, 0.0))
                    .append("</li>")
                    .append(System.lineSeparator()));
        result.append("\t</ul>\n")
              .append("\t<h3>Amount owned: ")
              .append(customerService.getTotalAmount(customerName).orElse(0.0))
              .append("</h3>\n\t<h3>You earned ")
              .append(renterPointsCalculatorService.getTotalFrequentRenterPoints(customerName).orElse(0))
              .append(" frequent renter points</h3>");
        result.append("\n  </body>").append("\n</html>");
        return result.toString();
    }
}
