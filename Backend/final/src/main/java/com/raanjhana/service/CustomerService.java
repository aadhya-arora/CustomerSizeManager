package com.raanjhana.service;

import com.raanjhana.model.Customer;
import com.raanjhana.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository repo;

    public boolean addCustomerIfNotExists(Customer c) {
        if (repo.existsByPhone(c.getPhoneNumber())) {
            return false;
        }
        repo.save(c);
        return true;
    }

    public int updateCustomer(Customer c) {
        return repo.update(c);
    }

    public List<Customer> getAll() {
        return repo.findAll();
    }

    public Customer getByPhone(String phone) {
        return repo.findByPhone(phone).stream().findFirst().orElse(null);
    }

    public int delete(String phone) {
        return repo.delete(phone);
    }
}
