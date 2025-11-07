package com.raanjhana.service;

import com.raanjhana.model.Customer;
import com.raanjhana.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    /**
     * ✅ Add a new customer if not already present.
     * Returns true if added successfully, false if the phone number already exists.
     */
    public boolean addCustomerIfNotExists(Customer c) {
        if (repo.findByPhoneNumber(c.getPhoneNumber()) != null) {
            return false; // Customer already exists
        }
        repo.save(c);
        return true;
    }

    /**
     * ✅ Update existing customer by phone number.
     * Returns the updated customer, or null if no such customer exists.
     */
    public Customer updateCustomer(Customer c) {
        Customer existing = repo.findByPhoneNumber(c.getPhoneNumber());
        if (existing != null) {
            existing.setName(c.getName());
            // Usually phoneNumber should remain constant, but included for completeness
            existing.setPhoneNumber(c.getPhoneNumber());
            return repo.save(existing);
        }
        return null;
    }

    /**
     * ✅ Create or update (unified method).
     * If customer exists by phoneNumber, update it; else create new.
     */
    public Customer saveOrUpdate(Customer c) {
        Customer existing = repo.findByPhoneNumber(c.getPhoneNumber());
        if (existing != null) {
            existing.setName(c.getName());
            existing.setPhoneNumber(c.getPhoneNumber());
            return repo.save(existing);
        } else {
            return repo.save(c);
        }
    }

    /**
     * ✅ Get all customers.
     */
    public List<Customer> getAll() {
        return repo.findAll();
    }

    /**
     * ✅ Get customer by phone number (returns Optional for safety).
     */
    public Optional<Customer> getByPhone(String phone) {
        return Optional.ofNullable(repo.findByPhoneNumber(phone));
    }

    /**
     * ✅ Delete a customer by phone number.
     * Returns true if deletion was successful, false if not found.
     */
    public boolean delete(String phone) {
        Customer existing = repo.findByPhoneNumber(phone);
        if (existing != null) {
            repo.delete(existing);
            return true;
        }
        return false;
    }
}
