package com.raanjhana.controller;

import com.raanjhana.model.Customer;
import com.raanjhana.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
    
     @Autowired
    private CustomerService service;

    @PostMapping("/add")
    public String addCustomer(@RequestBody Customer c) {
        boolean created = service.addCustomerIfNotExists(c);
        if (created) return "Customer created";
        else return "Customer already exists";
    }

    @GetMapping("/all")
    public List<Customer> getAll() {
        return service.getAll();
    }

    @GetMapping("/{phone}")
    public Customer getByPhone(@PathVariable String phone) {
        return service.getByPhone(phone);
    }

    @PutMapping("/update")
    public String update(@RequestBody Customer c) {
        service.updateCustomer(c);
        return "Customer updated";
    }

    @DeleteMapping("/{phone}")
    public String delete(@PathVariable String phone) {
        service.delete(phone);
        return "Customer deleted";
    }
}
