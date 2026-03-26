package com.raanjhana.repository;

import com.raanjhana.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
     Customer findByPhoneNumber(String customerPhoneNumber);
    boolean existsByCustomerPhoneNumber(String customerPhoneNumber);
}
