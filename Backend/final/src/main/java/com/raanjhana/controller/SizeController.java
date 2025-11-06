package com.raanjhana.controller;

import com.raanjhana.model.*;
import com.raanjhana.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class SizeController {

    @Autowired
    private SizeService sizeService;

    @Autowired
    private CustomerService customerService;

    private void ensureCustomerExists(String phoneNumber) {
        if (customerService.getByPhone(phoneNumber) == null) {
            customerService.addCustomerIfNotExists(new Customer(phoneNumber, "Unknown"));
        }
    }

    @PostMapping("/trouser/add")
    public String addTrouser(@RequestBody TrouserSize t) {
        ensureCustomerExists(t.getPhoneNumber());
        sizeService.addOrUpdateTrouser(t);
        return "Trouser size saved";
    }

    @GetMapping("/trouser/{phone}")
    public TrouserSize getTrouser(@PathVariable String phone) {
        return sizeService.getTrouser(phone);
    }


    @PostMapping("/sherwani/add")
    public String addSherwani(@RequestBody SherwaniSize s) {
        ensureCustomerExists(s.getPhoneNumber());
        sizeService.addOrUpdateSherwani(s);
        return "Sherwani size saved";
    }

    @GetMapping("/sherwani/{phone}")
    public SherwaniSize getSherwani(@PathVariable String phone) {
        return sizeService.getSherwani(phone);
    }

  
    @PostMapping("/shirt/add")
    public String addShirt(@RequestBody ShirtSize s) {
        ensureCustomerExists(s.getPhoneNumber());
        sizeService.addOrUpdateShirt(s);
        return "Shirt size saved";
    }

    @GetMapping("/shirt/{phone}")
    public ShirtSize getShirt(@PathVariable String phone) {
        return sizeService.getShirt(phone);
    }

    @PostMapping("/coat/add")
    public String addCoat(@RequestBody CoatSize s) {
        ensureCustomerExists(s.getPhoneNumber());
        sizeService.addOrUpdateCoat(s);
        return "Coat size saved";
    }

    @GetMapping("/coat/{phone}")
    public CoatSize getCoat(@PathVariable String phone) {
        return sizeService.getCoat(phone);
    }

    @PostMapping("/waistcoat/add")
    public String addWaistcoat(@RequestBody WaistcoatSize s) {
        ensureCustomerExists(s.getPhoneNumber());
        sizeService.addOrUpdateWaistcoat(s);
        return "Waistcoat size saved";
    }

    @GetMapping("/waistcoat/{phone}")
    public WaistcoatSize getWaistcoat(@PathVariable String phone) {
        return sizeService.getWaistcoat(phone);
    }

    @PostMapping("/kurta/add")
    public String addKurta(@RequestBody KurtaSize s) {
        ensureCustomerExists(s.getPhoneNumber());
        sizeService.addOrUpdateKurta(s);
        return "Kurta size saved";
    }

    @GetMapping("/kurta/{phone}")
    public KurtaSize getKurta(@PathVariable String phone) {
        return sizeService.getKurta(phone);
    }
}
