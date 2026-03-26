package com.raanjhana.repository;

import com.raanjhana.model.CoatSize;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface CoatRepository extends MongoRepository<CoatSize, String> {
    CoatSize findByCustomerPhoneNumber(String phoneNumber);
}
