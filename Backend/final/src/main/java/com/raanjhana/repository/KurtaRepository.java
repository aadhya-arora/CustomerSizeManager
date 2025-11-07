package com.raanjhana.repository;

import com.raanjhana.model.KurtaSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KurtaRepository extends JpaRepository<KurtaSize, Long> {
   KurtaSize findByCustomer_PhoneNumber(String phoneNumber);
}
