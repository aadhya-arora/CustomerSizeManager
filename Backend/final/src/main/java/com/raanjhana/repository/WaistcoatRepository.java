package com.raanjhana.repository;

import com.raanjhana.model.WaistcoatSize;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaistcoatRepository extends MongoRepository<WaistcoatSize, String> {
   WaistcoatSize findByCustomerPhoneNumber(String customerPhoneNumber);
}
