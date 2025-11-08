package com.raanjhana.repository;

import com.raanjhana.model.WaistcoatSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaistcoatRepository extends JpaRepository<WaistcoatSize, Long> {
   WaistcoatSize findByCustomer_PhoneNumber(String phoneNumber);
}
