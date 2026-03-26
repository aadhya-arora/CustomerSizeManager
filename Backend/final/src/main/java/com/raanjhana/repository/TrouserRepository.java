package com.raanjhana.repository;

import com.raanjhana.model.TrouserSize;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrouserRepository extends MongoRepository<TrouserSize, String> {
    TrouserSize findByCustomerPhoneNumber(String customerPhoneNumber);
}
