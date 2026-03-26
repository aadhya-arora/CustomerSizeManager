package com.raanjhana.repository;

import com.raanjhana.model.ShirtSize;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShirtRepository extends MongoRepository<ShirtSize, String> {
   ShirtSize findByCustomerPhoneNumber(String phoneNumber);
}
