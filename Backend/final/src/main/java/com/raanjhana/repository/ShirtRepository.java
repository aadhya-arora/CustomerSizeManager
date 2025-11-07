package com.raanjhana.repository;

import com.raanjhana.model.ShirtSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShirtRepository extends JpaRepository<ShirtSize, Long> {
   ShirtSize findByCustomer_PhoneNumber(String phoneNumber);
}
