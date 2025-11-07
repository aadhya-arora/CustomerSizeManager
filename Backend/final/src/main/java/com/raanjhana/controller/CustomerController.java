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
            String phone = customer.getPhoneNumber();

            // ✅ Use new JPA relationships
            if (trouserRepository.findByCustomer_PhoneNumber(phone) != null)
                result.add(Map.of("phoneNumber", phone, "category", "Trouser"));

            if (shirtRepository.findByCustomer_PhoneNumber(phone) != null)
                result.add(Map.of("phoneNumber", phone, "category", "Shirt"));

            if (coatRepository.findByCustomer_PhoneNumber(phone) != null)
                result.add(Map.of("phoneNumber", phone, "category", "Coat"));

            if (kurtaRepository.findByCustomer_PhoneNumber(phone) != null)
                result.add(Map.of("phoneNumber", phone, "category", "Kurta"));

            if (sherwaniRepository.findByCustomer_PhoneNumber(phone) != null)
                result.add(Map.of("phoneNumber", phone, "category", "Sherwani"));

            if (waistcoatRepository.findByCustomer_PhoneNumber(phone) != null)
                result.add(Map.of("phoneNumber", phone, "category", "Waistcoat"));
        }

        return result;
    }
}
