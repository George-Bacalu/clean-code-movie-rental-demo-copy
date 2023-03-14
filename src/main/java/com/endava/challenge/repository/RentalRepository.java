package com.endava.challenge.repository;

import com.endava.challenge.model.Rental;
import java.util.List;

public interface RentalRepository {

    List<Rental> findAll();
}
