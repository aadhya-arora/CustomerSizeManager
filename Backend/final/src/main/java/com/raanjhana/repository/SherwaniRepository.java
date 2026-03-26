package com.raanjhana.repository;

import com.raanjhana.model.SherwaniSize;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SherwaniRepository extends MongoRepository<SherwaniSize, String> {
   SherwaniSize findByCustomerPhoneNumber(String phoneNumber);
}
