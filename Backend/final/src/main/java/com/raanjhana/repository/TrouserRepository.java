package com.raanjhana.repository;

import com.raanjhana.model.TrouserSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrouserRepository extends JpaRepository<TrouserSize, Long> {
    TrouserSize findByCustomer_PhoneNumber(String phoneNumber);
}
