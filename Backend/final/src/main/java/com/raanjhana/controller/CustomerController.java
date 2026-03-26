package com.raanjhana.controller;

import com.raanjhana.model.Customer;
import com.raanjhana.repository.*;
import com.raanjhana.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.raanjhana.repository.TrouserRepository;
import com.raanjhana.repository.ShirtRepository;
import com.raanjhana.repository.CoatRepository;
import com.raanjhana.repository.KurtaRepository;
import com.raanjhana.repository.SherwaniRepository;
import com.raanjhana.repository.WaistcoatRepository;

import java.util.*;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @Autowired
    private TrouserRepository trouserRepository;

    @Autowired
    private ShirtRepository shirtRepository;

    @Autowired
    private CoatRepository coatRepository;

    @Autowired
    private KurtaRepository kurtaRepository;

    @Autowired
    private SherwaniRepository sherwaniRepository;

    @Autowired
    private WaistcoatRepository waistcoatRepository;

    // ---------------- CRUD ENDPOINTS ---------------- //

    @PostMapping("/add")
    public String addCustomer(@RequestBody Customer c) {
        boolean created = service.addCustomerIfNotExists(c);
        return created ? "Customer created" : "Customer already exists";
    }

    @PutMapping("/update")
    public String update(@RequestBody Customer c) {
        service.updateCustomer(c);
        return "Customer updated";
    }

    @GetMapping("/all")
    public List<Customer> getAll() {
        return service.getAll();
    }

    @GetMapping("/{phone}")
    public Customer getByPhone(@PathVariable String phone) {
        return service.getByPhone(phone).orElse(null);
    }

    @DeleteMapping("/{phone}")
    public String delete(@PathVariable String phone) {
        boolean deleted = service.delete(phone);
        return deleted ? "Customer deleted" : "Customer not found";
    }

    // ---------------- EXTRA: for ViewCustomer ---------------- //

    @GetMapping("/all-with-categories")
    public List<Map<String, String>> getAllCustomersWithCategories() {
        List<Map<String, String>> result = new ArrayList<>();

        List<Customer> allCustomers = service.getAll();
        for (Customer customer : allCustomers) {
            String phone = customer.getCustomerPhoneNumber();

            // ✅ Use new JPA relationships
            if (trouserRepository.findByCustomerPhoneNumber(phone) != null)
                result.add(Map.of(
                        "phoneNumber", phone,
                        "name", customer.getName(),
                        "category", "Trouser"
                ));

            if (shirtRepository.findByCustomerPhoneNumber(phone) != null)
                result.add(Map.of(
                        "phoneNumber", phone,
                        "name", customer.getName(),
                        "category", "Shirt"
                ));

            if (coatRepository.findByCustomerPhoneNumber(phone) != null)
                result.add(Map.of(
                        "phoneNumber", phone,
                        "name", customer.getName(),
                        "category", "Coat"
                ));

            if (kurtaRepository.findByCustomerPhoneNumber(phone) != null)
                result.add(Map.of(
                        "phoneNumber", phone,
                        "name", customer.getName(),
                        "category", "Kurta"
                ));

            if (sherwaniRepository.findByCustomerPhoneNumber(phone) != null)
                result.add(Map.of(
                        "phoneNumber", phone,
                        "name", customer.getName(),
                        "category", "Sherwani"
                ));

            if (waistcoatRepository.findByCustomerPhoneNumber(phone) != null)
                result.add(Map.of(
                        "phoneNumber", phone,
                        "name", customer.getName(),
                        "category", "Waistcoat"
                ));
        }

        return result;
    }
}
