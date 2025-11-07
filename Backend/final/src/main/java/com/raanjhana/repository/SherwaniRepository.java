package com.raanjhana.repository;

import com.raanjhana.model.SherwaniSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SherwaniRepository extends JpaRepository<SherwaniSize, Long> {
   SherwaniSize findByCustomer_PhoneNumber(String phoneNumber);
}
