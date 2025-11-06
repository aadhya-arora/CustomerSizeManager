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

    // Add/update trouser size. If customer not exists, create minimal customer entry.
    @PostMapping("/trouser")
    public String addTrouser(@RequestBody TrouserSize t) {
        // ensure customer exists
        if (customerService.getByPhone(t.getPhoneNumber()) == null) {
            customerService.addCustomerIfNotExists(new Customer(t.getPhoneNumber(), "Unknown"));
        }
        sizeService.addOrUpdateTrouser(t);
        return "Trouser size saved";
    }

    @GetMapping("/trouser/{phone}")
    public TrouserSize getTrouser(@PathVariable String phone) {
        return sizeService.getTrouser(phone);
    }

    // Sherwani
    @PostMapping("/sherwani")
    public String addSherwani(@RequestBody SherwaniSize s) {
        if (customerService.getByPhone(s.getPhoneNumber()) == null) {
            customerService.addCustomerIfNotExists(new Customer(s.getPhoneNumber(), "Unknown"));
        }
        sizeService.addOrUpdateSherwani(s);
        return "Sherwani size saved";
    }

    @GetMapping("/sherwani/{phone}")
    public SherwaniSize getSherwani(@PathVariable String phone) {
        return sizeService.getSherwani(phone);
    }

    // Shirt
    @PostMapping("/shirt")
    public String addShirt(@RequestBody ShirtSize s) {
        if (customerService.getByPhone(s.getPhoneNumber()) == null) {
            customerService.addCustomerIfNotExists(new Customer(s.getPhoneNumber(), "Unknown"));
        }
        sizeService.addOrUpdateShirt(s);
        return "Shirt size saved";
    }

    @GetMapping("/shirt/{phone}")
    public ShirtSize getShirt(@PathVariable String phone) {
        return sizeService.getShirt(phone);
    }

    // Coat
    @PostMapping("/coat")
    public String addCoat(@RequestBody CoatSize s) {
        if (customerService.getByPhone(s.getPhoneNumber()) == null) {
            customerService.addCustomerIfNotExists(new Customer(s.getPhoneNumber(), "Unknown"));
        }
        sizeService.addOrUpdateCoat(s);
        return "Coat size saved";
    }

    @GetMapping("/coat/{phone}")
    public CoatSize getCoat(@PathVariable String phone) {
        return sizeService.getCoat(phone);
    }

    // Waistcoat
    @PostMapping("/waistcoat")
    public String addWaistcoat(@RequestBody WaistCoatSize s) {
        if (customerService.getByPhone(s.getPhoneNumber()) == null) {
            customerService.addCustomerIfNotExists(new Customer(s.getPhoneNumber(), "Unknown"));
        }
        sizeService.addOrUpdateWaistcoat(s);
        return "Waistcoat size saved";
    }

    @GetMapping("/waistcoat/{phone}")
    public WaistCoatSize getWaistcoat(@PathVariable String phone) {
        return sizeService.getWaistcoat(phone);
    }

    
    @PostMapping("/kurta")
    public String addKurta(@RequestBody KurtaSize s) {
        if (customerService.getByPhone(s.getPhoneNumber()) == null) {
            customerService.addCustomerIfNotExists(new Customer(s.getPhoneNumber(), "Unknown"));
        }
        sizeService.addOrUpdateKurta(s);
        return "Kurta size saved";
    }

    @GetMapping("/kurta/{phone}")
    public KurtaSize getKurta(@PathVariable String phone) {
        return sizeService.getKurta(phone);
    }
}
