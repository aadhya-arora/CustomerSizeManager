package com.raanjhana.repository;

import com.raanjhana.model.KurtaSize;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KurtaRepository extends MongoRepository<KurtaSize, String> {
   KurtaSize findByCustomerPhoneNumber(String customerPhoneNumber);
}
