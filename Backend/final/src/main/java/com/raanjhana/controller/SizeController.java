package com.raanjhana.controller;

import com.raanjhana.model.*;
import com.raanjhana.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sizes")
@CrossOrigin(origins = "http://localhost:3000")
public class SizeController {

    @Autowired
    private SizeService sizeService;

    @Autowired
    private CustomerService customerService;

    /**
     * Ensures a Customer exists for the given phone number.
     * If not, creates a new Customer with that phone.
     */
    private Customer ensureCustomer(String phoneNumber) {
        return customerService.getByPhone(phoneNumber)
                .orElseGet(() -> {
                    Customer newCustomer = new Customer(phoneNumber, "Unknown");
                    customerService.addCustomerIfNotExists(newCustomer);
                    return newCustomer;
                });
    }

    // ---------- Trouser ---------- //

    @PostMapping("/trouser/add")
    public String addTrouser(@RequestBody TrouserSize t) {
        String phone = t.getCustomer().getPhoneNumber();
        Customer customer = ensureCustomer(phone);
        t.setCustomer(customer);
        sizeService.saveTrouser(t);
        return "Trouser size saved";
    }

    @PutMapping("/trouser/update")
    public String updateTrouser(@RequestBody TrouserSize t) {
        String phone = t.getCustomer().getPhoneNumber();
        Customer customer = ensureCustomer(phone);
        t.setCustomer(customer);
        sizeService.updateTrouser(t);
        return "Trouser size updated";
    }

    @GetMapping("/trouser/{phone}")
    public TrouserSize getTrouser(@PathVariable String phone) {
        return sizeService.getTrouserByPhone(phone);
    }

    // ---------- Sherwani ---------- //

    @PostMapping("/sherwani/add")
    public String addSherwani(@RequestBody SherwaniSize s) {
        String phone = s.getCustomer().getPhoneNumber();
        Customer customer = ensureCustomer(phone);
        s.setCustomer(customer);
        sizeService.saveSherwani(s);
        return "Sherwani size saved";
    }

    @PutMapping("/sherwani/update")
    public String updateSherwani(@RequestBody SherwaniSize s) {
        String phone = s.getCustomer().getPhoneNumber();
        Customer customer = ensureCustomer(phone);
        s.setCustomer(customer);
        sizeService.updateSherwani(s);
        return "Sherwani size updated";
    }

    @GetMapping("/sherwani/{phone}")
    public SherwaniSize getSherwani(@PathVariable String phone) {
        return sizeService.getSherwaniByPhone(phone);
    }

    // ---------- Shirt ---------- //

    @PostMapping("/shirt/add")
    public String addShirt(@RequestBody ShirtSize s) {
        String phone = s.getCustomer().getPhoneNumber();
        Customer customer = ensureCustomer(phone);
        s.setCustomer(customer);
        sizeService.saveShirt(s);
        return "Shirt size saved";
    }

    @PutMapping("/shirt/update")
    public String updateShirt(@RequestBody ShirtSize s) {
        String phone = s.getCustomer().getPhoneNumber();
        Customer customer = ensureCustomer(phone);
        s.setCustomer(customer);
        sizeService.updateShirt(s);
        return "Shirt size updated";
    }

    @GetMapping("/shirt/{phone}")
    public ShirtSize getShirt(@PathVariable String phone) {
        return sizeService.getShirtByPhone(phone);
    }

    // ---------- Coat ---------- //

    @PostMapping("/coat/add")
    public String addCoat(@RequestBody CoatSize s) {
        String phone = s.getCustomer().getPhoneNumber();
        Customer customer = ensureCustomer(phone);
        s.setCustomer(customer);
        sizeService.saveCoat(s);
        return "Coat size saved";
    }

    @PutMapping("/coat/update")
    public String updateCoat(@RequestBody CoatSize s) {
        String phone = s.getCustomer().getPhoneNumber();
        Customer customer = ensureCustomer(phone);
        s.setCustomer(customer);
        sizeService.updateCoat(s);
        return "Coat size updated";
    }

    @GetMapping("/coat/{phone}")
    public CoatSize getCoat(@PathVariable String phone) {
        return sizeService.getCoatByPhone(phone);
    }

    // ---------- Waistcoat ---------- //

    @PostMapping("/waistcoat/add")
    public String addWaistcoat(@RequestBody WaistcoatSize s) {
        String phone = s.getCustomer().getPhoneNumber();
        Customer customer = ensureCustomer(phone);
        s.setCustomer(customer);
        sizeService.saveWaistcoat(s);
        return "Waistcoat size saved";
    }

    @PutMapping("/waistcoat/update")
    public String updateWaistcoat(@RequestBody WaistcoatSize s) {
        String phone = s.getCustomer().getPhoneNumber();
        Customer customer = ensureCustomer(phone);
        s.setCustomer(customer);
        sizeService.updateWaistcoat(s);
        return "Waistcoat size updated";
    }

    @GetMapping("/waistcoat/{phone}")
    public WaistcoatSize getWaistcoat(@PathVariable String phone) {
        return sizeService.getWaistcoatByPhone(phone);
    }

    // ---------- Kurta ---------- //

    @PostMapping("/kurta/add")
    public String addKurta(@RequestBody KurtaSize s) {
        String phone = s.getCustomer().getPhoneNumber();
        Customer customer = ensureCustomer(phone);
        s.setCustomer(customer);
        sizeService.saveKurta(s);
        return "Kurta size saved";
    }

    @PutMapping("/kurta/update")
    public String updateKurta(@RequestBody KurtaSize s) {
        String phone = s.getCustomer().getPhoneNumber();
        Customer customer = ensureCustomer(phone);
        s.setCustomer(customer);
        sizeService.updateKurta(s);
        return "Kurta size updated";
    }

    @GetMapping("/kurta/{phone}")
    public KurtaSize getKurta(@PathVariable String phone) {
        return sizeService.getKurtaByPhone(phone);
    }
}
