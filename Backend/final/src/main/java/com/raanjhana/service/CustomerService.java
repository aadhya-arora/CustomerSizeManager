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

    public boolean addCustomerIfNotExists(Customer c) {
        if (repo.existsById(c.getCustomerPhoneNumber())) {
            return false; // Customer already exists
        }
        repo.save(c);
        return true;
    }
    public Customer updateCustomer(Customer c) {
        return repo.findById(c.getCustomerPhoneNumber())
                .map(existing -> {
                    existing.setName(c.getName());
                    return repo.save(existing);
                }).orElse(null);
    }

    public Customer saveOrUpdate(Customer c) {
        return repo.save(c);
    }

    public List<Customer> getAll() {
        return repo.findAll();
    }

    public Optional<Customer> getByPhone(String phone) {
        return repo.findById(phone);
    }

    public boolean delete(String phone) {
        if (repo.existsById(phone)) {
            repo.deleteById(phone);
            return true;
        }
        return false;
    }
}