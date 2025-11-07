package com.raanjhana.repository;

import com.raanjhana.model.CoatSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoatRepository extends JpaRepository<CoatSize, Long> {
    CoatSize findByCustomer_PhoneNumber(String phoneNumber);
}
