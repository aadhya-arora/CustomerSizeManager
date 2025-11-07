package com.raanjhana.controller;

import com.raanjhana.model.Customer;
import com.raanjhana.repository.*;
import com.raanjhana.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // ---------------- Existing CRUD endpoints ---------------- //

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

    // ---------------- NEW endpoint for ViewCustomer ---------------- //

    @GetMapping("/all-with-categories")
    public List<Map<String, String>> getAllCustomersWithCategories() {
        List<Map<String, String>> result = new ArrayList<>();
        List<Customer> allCustomers = service.getAll();

        for (Customer customer : allCustomers) {
            String phone = customer.getPhoneNumber();

            // ✅ Use findByPhone() for each size category
            if (trouserRepository.findByPhone(phone) != null) {
                result.add(Map.of("phoneNumber", phone, "category", "Trouser"));
            }
            if (shirtRepository.findByPhone(phone) != null) {
                result.add(Map.of("phoneNumber", phone, "category", "Shirt"));
            }
            if (coatRepository.findByPhone(phone) != null) {
                result.add(Map.of("phoneNumber", phone, "category", "Coat"));
            }
            if (kurtaRepository.findByPhone(phone) != null) {
                result.add(Map.of("phoneNumber", phone, "category", "Kurta"));
            }
            if (sherwaniRepository.findByPhone(phone) != null) {
                result.add(Map.of("phoneNumber", phone, "category", "Sherwani"));
            }
            if (waistcoatRepository.findByPhone(phone) != null) {
                result.add(Map.of("phoneNumber", phone, "category", "Waistcoat"));
            }
        }

        return result;
    }
}
